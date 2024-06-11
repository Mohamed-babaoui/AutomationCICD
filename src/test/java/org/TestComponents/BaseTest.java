package org.TestComponents;

import PageObjects.LandingPage;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import com.fasterxml.jackson.core.type.TypeReference;


public class BaseTest {
    public WebDriver driver;
    public LandingPage landingClass;
    public List<String> productsList;


    public WebDriver initializeDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return  driver;
    }
    public void  getProducts() throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("C:\\Users\\a904051\\IdeaProjects\\SeleniumFrameworkDesign\\src\\main\\java\\resources\\Products.properties");
        prop.load(fis);
        productsList= Arrays.asList(prop.getProperty("products").split(","));

    }
    public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException
    {
        //read json to string
        String jsonContent = 	FileUtils.readFileToString(new File(filePath),
                StandardCharsets.UTF_8);

        //String to HashMap- Jackson Databind

        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
        });
        return data;

        //{map, map}

    }
   //Takes Scre
   public String getScreenshot(String testCaseName,WebDriver driver) throws IOException

   {

       TakesScreenshot ts = (TakesScreenshot)driver;

       File source = ts.getScreenshotAs(OutputType.FILE);       // String modifiedPath = originalPath.


       File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");

       FileUtils.copyFile(source, file);
       String pathToReturn=(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png").replace("\\", "//");
       System.out.println(pathToReturn);
       return pathToReturn;

   }
    public String getScreenshot(String testCaseName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String filePath = System.getProperty("user.dir") + File.separator + "reports" + File.separator + testCaseName + ".png";
        File file = new File(filePath);
        FileUtils.copyFile(source, file);
        return filePath;
    }


    @BeforeMethod(alwaysRun=true)

    public LandingPage launchApplication() throws IOException {
       // getProducts();
        driver = initializeDriver();
        landingClass=new LandingPage(driver);
        landingClass.goTo();
       return landingClass;


    }


    @AfterMethod(alwaysRun=true)

    public void tearDown() {
        driver.quit();
    }



}
