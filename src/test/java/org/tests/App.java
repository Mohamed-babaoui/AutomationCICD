/*package org;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.tests.LoginTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

/*

public class App {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = SetupDriver.setup("https://rahulshettyacademy.com/client");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String mail = "Med.baba@gmail.com";
        String password = "Password@2019";

        driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys(mail);
        driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys(password);
        driver.findElement(By.cssSelector("#login")).click();
        Thread.sleep(3000);

        List<WebElement> webElementList = driver.findElements(By.xpath("//div[@class='card-body']"));
        WebElement CoatElement = webElementList.
                stream().
                filter(element -> element.
                        findElement(By.tagName("b")).
                        getText().
                        equals("ZARA COAT 3")).findFirst().orElse(null);
        System.out.println(CoatElement);
        CoatElement.findElement(By.xpath("button[last()]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
        System.out.println(driver.findElement(By.id("toast-container")).getText());
/*---CHECKOUT PAGE --- ---CHECKOUT PAGE --- ---CHECKOUT PAGE --- ---CHECKOUT PAGE ------CHECKOUT PAGE --- */
   /*     driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".cartSection h3")));
        List<WebElement> listOfItems = driver.findElements(By.cssSelector(".cartSection h3"));
        System.out.println(driver.findElement(By.cssSelector(".cartSection h3")).getText());
        boolean o=listOfItems
                .stream()
                .anyMatch(e -> e.getText()
                        .equalsIgnoreCase("ZARA COAT 3"));
        Assert.assertTrue(o);
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait until the total row button is visible and then click it
        //wait2.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".totalRow button")));
        //driver.findElement(By.cssSelector(".totalRow button")).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(//button[@class='btn btn-primary'])[3]")));

//driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement checkout = driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[3]"));

        js.executeScript("arguments[0].click();", checkout);
        js.executeScript("window.scrollBy(0,100)");

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".action__submit")));

        WebElement placeOrder =driver.findElement(By.cssSelector(".action__submit"));

        js.executeScript("arguments[0].click();", placeOrder);

        Actions a = new Actions(driver);

        a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));

        driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();

        WebElement submit =  driver.findElement(By.cssSelector(".action__submit"));
        js.executeScript("arguments[0].click();",submit);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".hero-primary")));
        String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
       WebElement Home= driver.findElement(By.xpath("//button[@routerlink='/dashboard/']"));
        js.executeScript("arguments[0].click();",Home);
      //  Assert.assertEquals(1,driver.getCurrentUrl());




    }
}*/


