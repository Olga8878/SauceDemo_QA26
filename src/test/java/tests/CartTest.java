package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.Retry;

public class CartTest extends BaseTest {

    @DataProvider(name = "productsData")
    public Object[][] getProductsData() {
        return new Object[][]{
                {"Sauce Labs Fleece Jacket", "$49.99", "It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office."},
                {"Sauce Labs Backpack", "$29.99", "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection."}
        };
    }

    @Test(dataProvider = "productsData", description = "Check adding multiple items to the shopping cart", groups = "Regression")
    public void addToCartItems(String productName, String productPrice, String productDescription) {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickAddCartButton(productName);
        cartPage.clickCartLink();
        Assert.assertTrue(productsPage.isShoppingCartDisplayed());
        Assert.assertEquals(cartPage.getProductPrice(productName), productPrice);
        Assert.assertEquals(cartPage.getProductDescription(productName), productDescription);
        cartPage.clickCheckoutButton();
        Assert.assertTrue(cartPage.showCheckoutInfo(), "Checkout: Your Information");
    }

    @Test(description = "Check adding and removing an item from the shopping cart", groups = "Regression", retryAnalyzer = Retry.class)
    public void addToCartItemsAndRemoveItem() {
        String firstProductName = "Sauce Labs Fleece Jacket";
        String secondProductName = "Sauce Labs Backpack";
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickAddCartButton(firstProductName);
        productsPage.clickAddCartButton(secondProductName);
        cartPage.clickCartLink();
        Assert.assertTrue(productsPage.isShoppingCartDisplayed());
        Assert.assertEquals(cartPage.getProductPrice(firstProductName), "$49.99");
        Assert.assertEquals(cartPage.getProductDescription(firstProductName), "It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.");
        Assert.assertEquals(cartPage.getProductPrice(secondProductName), "$29.99");
        Assert.assertEquals(cartPage.getProductDescription(secondProductName), "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.");
        Assert.assertEquals(cartPage.getCartBadge(), "2");
        cartPage.clickRemoveButton(secondProductName);
        Assert.assertEquals(cartPage.getCartBadge(), "1");
        cartPage.clickCheckoutButton();
        Assert.assertTrue(cartPage.showCheckoutInfo(), "Checkout: Your Information");
    }
}