package StepDefinitions;

import PageObjects.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.TestComponents.BaseTest;
import org.TestComponents.BaseTest2;
import org.testng.Assert;

import java.io.IOException;

public class StepDefinitionImpl extends BaseTest2 {
    public LandingPage landingPage;
    public ProductsCatalogue productCatalogue;
    public CheckoutPage checkoutPage;
    public ConfirmationPage confirmationPage;
    public CardPage cardPage;

    @Given("Landed on E-Commerce website")
    public void landed_on_E_Commerce_website() throws IOException {
        landingPage = launchApplication();

    }

    // @Given("^Login using (.+) and (.+)$")
    @And("Login using {} and {}")
    public void loginUsingAnd(String mail, String pwd) {
        productCatalogue = landingPage.LoginMethod(mail, pwd);

    }

    @When("Select the  {} to purchase")
    public void selectTheToPurchase(String prdct) throws InterruptedException {
        productCatalogue.addProductToCart(prdct);


    }

    @And("check{} in checkoutpage")
    public void checkInCheckoutpage(String prdct) throws InterruptedException {
        checkoutPage = productCatalogue.GotoCheckoutPage();
        boolean exists = checkoutPage.VerifyProductDisplay(prdct);
        Assert.assertTrue(exists);

    }

    @Then("{string} should be displayed")
    public void shouldBeDisplayed(String mssg) {
        cardPage = checkoutPage.goToCardPage();
        cardPage.selectCounty("Morocco");
        confirmationPage = cardPage.goToConfirmationPage();
        boolean okay = confirmationPage.checkConfirmationMessage(mssg);
        Assert.assertTrue(okay);
        tearDown();

    }

    @Then("{string} message is displayed")
    public void messageIsDisplayed(String arg0) {
        Assert.assertEquals(arg0, landingClass.getErrorMessage());
        tearDown();
    }
}



