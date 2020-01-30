package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.LandingPage;
import pages.ProductPage;

/**
 * @author Sergiu Hojbota on 30/01/2020
 */
public class BaseTest {
    //-----------------------------------Global Variables-----------------------------------
    //Declare a Webdriver variable
    public WebDriver driver;

    //Declare a test URL variable
    public String testURL = "https://skyronic.github.io/vue-spa/#/";

    LandingPage landingPage;
    ProductPage productPage;

    //-----------------------------------Test Setup-----------------------------------
    @BeforeClass
    public void setupTest() {
        //Create a new ChromeDriver
        driver = new ChromeDriver();

        //Go to the main page
        driver.navigate().to(testURL);

        landingPage = new LandingPage();
        PageFactory.initElements(driver, landingPage);

        productPage = new ProductPage();
        PageFactory.initElements(driver, productPage);

    }

    //-----------------------------------Test TearDown-----------------------------------
    @AfterClass
    public void teardownTest() {
        //Close browser and end the session
        driver.quit();
    }


}
