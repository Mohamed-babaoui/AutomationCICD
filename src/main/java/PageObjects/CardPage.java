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
import java.util.List;

public class CardPage extends AbstratComponents {
    WebDriver driver;

    public CardPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = ".totalRow button")
            WebElement cardPageButton;
    @FindBy(css = "[placeholder='Select Country']")
    WebElement countrySelector;
    @FindBy(css = ".fa-search")
    private WebElement selectCountry;
    @FindBy(css = ".action__submit")
    private WebElement countriesField;
    @FindBy(css = ".action__submit")
    WebElement confirmationPageButton;

public void selectCounty(String countryName)
{
    JavascriptExecutor js = (JavascriptExecutor) driver;

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".action__submit")));

  // WebElement placeOrder =driver.findElement(By.cssSelector(".action__submit"));

    js.executeScript("arguments[0].click();", countriesField);

    Actions a = new Actions(driver);
    a.sendKeys(countrySelector, countryName).build().perform();
    waitForVisibility(5,By.cssSelector(".fa-search"));
    selectCountry.click();



}
public ConfirmationPage goToConfirmationPage() {
    JavascriptExecutor js = (JavascriptExecutor) driver;
   js.executeScript("arguments[0].click();",confirmationPageButton);
    //cardPageButton.click();
    return new ConfirmationPage(driver);
}







}
