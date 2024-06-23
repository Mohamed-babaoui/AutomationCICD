package org.tests;

import PageObjects.CardPage;
import PageObjects.CheckoutPage;
import PageObjects.ConfirmationPage;
import PageObjects.ProductsCatalogue;
import org.TestComponents.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class ParamLoginTest extends BaseTest {
    ProductsCatalogue productCatalogue;
    CheckoutPage checkoutPage;
    ConfirmationPage confirmationPage;
    CardPage cardPage;

    String mail = "Med.baba@gmail.com";
    String password = "Password@2019";

    //String wantedElement = "ZARA COAT 3";
    String expectedConfirmMessage = "THANKYOU FOR THE ORDER.";

   // @Parameters({"product"})
    @Test
    void loginTest() throws InterruptedException {
        String product=System.getProperty("product");
        productCatalogue = landingClass.LoginMethod(mail, password);
        List<WebElement> productsElements = productCatalogue.getElements();
        productCatalogue.addProductToCart(product);

        checkoutPage = productCatalogue.GotoCheckoutPage();
        boolean exists = checkoutPage.VerifyProductDisplay(product);
        Assert.assertTrue(exists);
        cardPage = checkoutPage.goToCardPage();
        cardPage.selectCounty("Morocco");
        confirmationPage = cardPage.goToConfirmationPage();
        boolean okay = confirmationPage.checkConfirmationMessage(expectedConfirmMessage);
        Assert.assertTrue(okay);
    }

}