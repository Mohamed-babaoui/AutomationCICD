package org.tests;

import PageObjects.CheckoutPage;
import PageObjects.ProductsCatalogue  ;
import org.TestComponents.BaseTest;
import org.TestComponents.Retry;
import org.testng.annotations.Test;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class ErrorValidationsTest extends BaseTest {
    ProductsCatalogue productCatalogue;
    CheckoutPage checkoutPage;

    String mail = "Med.baba@gmail.com";
    String password = "Password@2019";


    @Test(groups= {"ErrorHandling"})
    public void LoginErrorValidation() {

        landingClass.LoginMethod("anshika@gmal.com", "Iamki000");

        Assert.assertEquals("Incorrect email or password.", landingClass.getErrorMessage());
        landingClass.goTo();
    }

    @Test(retryAnalyzer = Retry.class)
    public void ProductErrorValidation() throws InterruptedException {
        productCatalogue = landingClass.LoginMethod(mail, password);


        List<WebElement> productsElements = productCatalogue.getElements();
        productCatalogue.addProductToCart("ZARA COAT 3");


        checkoutPage = productCatalogue.GotoCheckoutPage();
        boolean exists = checkoutPage.VerifyProductDisplay("ZARA COAT c3");
        Assert.assertFalse(exists);
        driver.quit();


    }


}
