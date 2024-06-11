package PageObjects;

import AbstractComponents.AbstratComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstratComponents {
    WebDriver driver;
    public  LandingPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="userEmail")
    WebElement userEmail;

    @FindBy(id="userPassword")
    WebElement userPassword;

    @FindBy(id="login")
    WebElement loginButton;
    @FindBy(css="[class*='flyInOut']")
    WebElement errorMessage;


    public ProductsCatalogue LoginMethod(String email,String password)
    {
        userEmail.sendKeys(email);
        userPassword.sendKeys(password);
        loginButton.click();
        return new ProductsCatalogue(driver);

    }

    public void goTo()
    {
        driver.get("https://rahulshettyacademy.com/client");
    }
    public String getErrorMessage()
    {
        waitForWebElementToAppear(errorMessage);
        return errorMessage.getText();
    }



}
