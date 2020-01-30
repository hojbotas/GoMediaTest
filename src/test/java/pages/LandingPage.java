package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

/**
 * @author Sergiu Hojbota on 30/01/2020
 */
public class LandingPage extends BasePage {
    @FindBy(how = How.CSS, using = ".product .title")
    public List<WebElement> productTitles;

    @FindBy(how = How.CSS, using = ".product .price")
    public List<WebElement> productPrices;

    @FindBy(how = How.CLASS_NAME, using = "help-text")
    public WebElement helpText;


}
