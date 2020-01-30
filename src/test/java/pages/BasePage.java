package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Sergiu Hojbota on 30/01/2020
 */
public class BasePage {

    public static void waitForElementVisibility(WebDriver driver, WebElement webElement, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutSeconds);
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public static boolean isElementPresent(WebElement el) {
        try {
            el.isDisplayed();

        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }
}
