package PageObjects;

import AbstractComponents.AbstratComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class CheckoutPage extends AbstratComponents {
    WebDriver driver;

    public CheckoutPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

   // @FindBy(css = ".cartSection h3")
          // List<WebElement> ;

    @FindBy(css = ".cartSection h3")
    private List<WebElement> elementsList;
    @FindBy(css = ".totalRow button")
    WebElement cardPageButton;





   public Boolean VerifyProductDisplay(String productName) {
       // Ensure elementsList is populated
       if (elementsList.isEmpty()) {
           System.out.println("Elements list is empty, retrying...");
           elementsList = driver.findElements(By.cssSelector(".cartSection h3"));
       }

       System.out.println(elementsList.isEmpty() ? "Is empty from method" : "It is not empty from method");

       return elementsList.stream().anyMatch(product -> product.getText().equalsIgnoreCase(productName));
   }
    public CardPage goToCardPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        waitForVisibility(5,By.cssSelector(".totalRow button"));
        js.executeScript("arguments[0].click();", cardPageButton);
        js.executeScript("window.scrollBy(0,100)");
        return new CardPage(driver);


    }


}
