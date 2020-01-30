package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author Sergiu Hojbota on 30/01/2020
 */
public class ProductPage {
    @FindBy(how = How.CLASS_NAME, using = "inventory")
    public WebElement inventory;

    @FindBy(how = How.CLASS_NAME, using = "add-button")
    public WebElement addToCart;

}
