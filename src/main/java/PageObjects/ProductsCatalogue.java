package PageObjects;



import AbstractComponents.AbstratComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductsCatalogue extends AbstratComponents {
    WebDriver driver;


    By prodcutBy=By.cssSelector(".mb-3");
    By prodcutAfterCheckout=By.id("toast-container");
    By diplayer=By.id("toast-container");
    By TobeInvisible=By.cssSelector(".ng-animating");

    public ProductsCatalogue(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//div[@class='card-body']")
    List<WebElement> elementslist;
    @FindBy(id = "toast-container")
    WebElement afterCheckout;
    @FindBy(css = "[routerlink*='cart']")
    WebElement checkoutButton;
    @FindBy(css = ".mb-3")
    List<WebElement> products;

    @FindBy(css = ".ng-animating")
    WebElement spinner;

    By productsBy = By.cssSelector(".mb-3");
    By addToCart = By.cssSelector(".card-body button:last-of-type");
    By toastMessage = By.cssSelector("#toast-container");

    By buttonOfElement=By.xpath("button[last()]");

    public List<WebElement> getElements(){
        waitForVisibility(5,prodcutBy);
        return elementslist;
    }


    public void addProductToCart(String productName) throws InterruptedException
    {
        WebElement prod = getProductByName(productName);
        prod.findElement(addToCart).click();
        waitForElementToAppear(toastMessage);
        waitForElementToDisappear(spinner);


    }
    public WebElement getProductByName(String productName)
    {
        WebElement prod =	getElements().stream().filter(product->
                product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
        return prod;
    }


    public CheckoutPage GotoCheckoutPage() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton));
        Thread.sleep(2000); // Consider replacing this with a more reliable wait
        checkoutButton.click();

        // Additional wait to ensure the elements are loaded
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".cartSection h3")));
        return new CheckoutPage(driver);
    }

}
