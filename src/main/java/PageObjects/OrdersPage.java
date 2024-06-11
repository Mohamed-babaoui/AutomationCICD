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

public class OrdersPage extends AbstratComponents {
    WebDriver driver;

    public OrdersPage(WebDriver driver){
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
    @FindBy(css = "[routerlink*='cart']")
    WebElement MyOrders;

public WebDriver GotoOrdersTab()
{
    MyOrders.click();
    return driver;
}
public boolean verifyOrder(String product){
List<WebElement> webElementList=driver.findElements(By.xpath("//tbody/tr/td[2]"));
return webElementList.stream().anyMatch(WebElement->WebElement.getText().equalsIgnoreCase(product));
}







}
