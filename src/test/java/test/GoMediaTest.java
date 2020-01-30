package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import static pages.BasePage.isElementPresent;
import static pages.BasePage.waitForElementVisibility;

/**
 * @author Sergiu Hojbota on 30/01/2020
 */

/*****************************************************************************
 * Description: This is for the Go Media test.
 *
 * Task:
 *
 * Write an automation test in java for the single page application available under this url:
 *
 * https://skyronic.github.io/vue-spa/#/​ following things needed to be tested:
 *******************************************************************************/

public class GoMediaTest extends BaseTest {

    //-----------------------------------Tests-----------------------------------
    @Test(description = "When the page loads, 3 items should be displayed Ipad 4 Mini, H&M T-Shirt White and Charli " +
            "XCX - Sucker CD in exact order and have the following prices: $ 500.01, $ 10.99 $ 19.99 respectively.",
            priority = 1)
    public void firstTest() {
        // First we wait for the page to load:
        waitForElementVisibility(driver, landingPage.helpText, 10);

        //Then we assert on the titles of the products:
        Assert.assertEquals(landingPage.productTitles.get(0).getText(), "iPad 4 Mini");

        Assert.assertEquals(landingPage.productTitles.get(1).getText(), "H&M T-Shirt White");

        Assert.assertEquals(landingPage.productTitles.get(2).getText(), "Charli XCX - Sucker CD");

        //Then we assert on the prices of the products:
        Assert.assertEquals(landingPage.productPrices.get(0).getText(), "$ 500.01");

        Assert.assertEquals(landingPage.productPrices.get(1).getText(), "$ 10.99");

        Assert.assertEquals(landingPage.productPrices.get(2).getText(), "$ 19.99");
    }

    @Test(description = "If User click on Ipad 4 Mini, the product detail page should be displayed. With the “In " +
            "stock” value of 2. There should be a button “Add to cart”", priority = 2)
    public void secondTest() {
        landingPage.productTitles.get(0).click();

        Assert.assertEquals(productPage.inventory.getText(), "In Stock: 2");

        Assert.assertTrue(isElementPresent(productPage.addToCart), "The add to cart button was not displayed!");
    }

    @Test(description = "If an item is added to cart, the number items in card in header should be updated",
            priority = 3)
    public void thirdTest() {
        productPage.addToCart.click();

        Assert.assertEquals(productPage.inventory.getText(), "In Stock: 1");
    }

    @Test(description = "It should not be possible to add more items into cart than there is in stock.",
            priority = 4)
    public void fourthTest() {
        productPage.addToCart.click();
        productPage.addToCart.click();

        Assert.assertEquals(productPage.addToCart.getText(), "Out Of Stock");
    }
}
