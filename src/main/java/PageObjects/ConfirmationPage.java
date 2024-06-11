package PageObjects;

import AbstractComponents.AbstratComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConfirmationPage extends AbstratComponents {
    WebDriver driver;

    public ConfirmationPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = ".totalRow button")
            WebElement cardPageButton;
    @FindBy(css = ".hero-primary")
            WebElement confirmationPageMessage;


public Boolean checkConfirmationMessage(String expectedMessage) {
    waitForVisibility(5,By.cssSelector(".hero-primary"));
    System.out.println(confirmationPageMessage.getText());
    return confirmationPageMessage.getText().equalsIgnoreCase(expectedMessage);
}



}
