package org.tests;

import PageObjects.*;
import org.TestComponents.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class LoginTest extends BaseTest {
    ProductsCatalogue productCatalogue;
    CheckoutPage checkoutPage;
    ConfirmationPage confirmationPage;
    CardPage cardPage;

    String mail = "Med.baba@gmail.com";
    String password = "Password@2019";

    //String wantedElement = "ZARA COAT 3";
    String expectedConfirmMessage = "THANKYOU FOR THE ORDER.";


    @Test(dataProvider = "getData", groups = "Purchase")
    void loginTest(HashMap<String, String> input) throws InterruptedException {
        productCatalogue = landingClass.LoginMethod(input.get("email"), input.get("password"));
        List<WebElement> productsElements = productCatalogue.getElements();
        productCatalogue.addProductToCart(input.get("product"));

        checkoutPage = productCatalogue.GotoCheckoutPage();
        boolean exists = checkoutPage.VerifyProductDisplay(input.get("product"));
        Assert.assertTrue(exists);
        cardPage = checkoutPage.goToCardPage();
        cardPage.selectCounty("Morocco");
        confirmationPage = cardPage.goToConfirmationPage();
        boolean okay = confirmationPage.checkConfirmationMessage(expectedConfirmMessage);
        Assert.assertTrue(okay);
    }

    @DataProvider
    public Object[][] getData() throws IOException {
        List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir") + "//src//test//java//org//data//PurchaseOrder.json");

        return new Object[][]{{data.get(0)}, {data.get(1)}, {data.get(2)}};
        // List<HashMap<String,String >> listofData=reader.getJsonDataToMap();
/*        HashMap<String, String> map = new HashMap<String, String>();
        map.put("email", "anshika@gmail.com");
        map.put("password", "Iamking@000");
        map.put("product", "ZARA COAT 3");

        HashMap<String, String> map1 = new HashMap<String, String>();
        map1.put("email", "Med.baba@gmail.com");
        map1.put("password", "Password@2019");
        map1.put("product", "ADIDAS ORIGINAL");

        HashMap<String, String> map2 = new HashMap<String, String>();
        map2.put("email", "Med.baba@gmail.com");
        map2.put("password", "Password@2019");
        map2.put("product", "IPHONE 13 PRO");
*/

    }

}

