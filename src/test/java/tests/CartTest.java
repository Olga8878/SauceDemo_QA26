package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.*;

public class CartTest extends BaseTest {
    @Test
    public void addToCartItems() {
        String firstProductName = "Sauce Labs Fleece Jacket";
        String secondProductName2 = "Sauce Labs Backpack";
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickAddCartButton(firstProductName);
        productsPage.clickAddCartButton(secondProductName2);
        cartPage.clickCartLink();
        Assert.assertTrue(productsPage.isShoppingCartDisplayed());
        Assert.assertEquals(cartPage.getProductPrice(firstProductName), "$49.99");
        Assert.assertEquals(cartPage.getProductDescription(firstProductName), "It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.");
        Assert.assertEquals(cartPage.getProductPrice(secondProductName2), "$29.99");
        Assert.assertEquals(cartPage.getProductDescription(secondProductName2), "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.");
        cartPage.clickCheckoutButton();
        Assert.assertTrue(cartPage.showCheckoutInfo(), "Checkout: Your Information");
    }

    @Test
    public void addToCartItemsAndRemoveItem() {
        String firstProductName = "Sauce Labs Fleece Jacket";
        String secondProductName2 = "Sauce Labs Backpack";
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickAddCartButton(firstProductName);
        productsPage.clickAddCartButton(secondProductName2);
        cartPage.clickCartLink();
        Assert.assertTrue(productsPage.isShoppingCartDisplayed());
        Assert.assertEquals(cartPage.getProductPrice(firstProductName), "$49.99");
        Assert.assertEquals(cartPage.getProductDescription(firstProductName), "It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.");
        Assert.assertEquals(cartPage.getProductPrice(secondProductName2), "$29.99");
        Assert.assertEquals(cartPage.getProductDescription(secondProductName2), "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.");
        Assert.assertEquals(cartPage.getCartBadge(), "2");
        cartPage.clickRemoveButton(secondProductName2);
        Assert.assertEquals(cartPage.getCartBadge(), "1");
        cartPage.clickCheckoutButton();
        Assert.assertTrue(cartPage.showCheckoutInfo(), "Checkout: Your Information");
    }
}