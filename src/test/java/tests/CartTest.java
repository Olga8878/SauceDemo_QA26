package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.*;

public class CartTest extends BaseTest {
    @Test
    public void addToCartItems() {
        String productName = "Sauce Labs Fleece Jacket";
        String productName2 = "Sauce Labs Backpack";
        loginPage.open();
        LoginPage.login("standard_user", "secret_sauce");
        productsPage.clickAddCartButton(productName);
        productsPage.clickAddCartButton(productName2);
        CartPage.clickCartLink();
        Assert.assertTrue(productsPage.isShoppingCartDisplayed());
        Assert.assertEquals(cartPage.getProductPrice(productName), "$49.99");
        Assert.assertEquals(cartPage.getProductDescription(productName), "It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.");
        Assert.assertEquals(cartPage.getProductPrice(productName2), "$29.99");
        Assert.assertEquals(cartPage.getProductDescription(productName2), "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.");
        CartPage.clickCheckoutButton();
        Assert.assertTrue(cartPage.showCheckoutInfo(), "Checkout: Your Information");
    }

    @Test
    public void addToCartItemsAndRemoveItem() throws InterruptedException {
        String productName = "Sauce Labs Fleece Jacket";
        String productName2 = "Sauce Labs Backpack";
        loginPage.open();
        LoginPage.login("standard_user", "secret_sauce");
        productsPage.clickAddCartButton(productName);
        productsPage.clickAddCartButton(productName2);
        CartPage.clickCartLink();
        Assert.assertTrue(productsPage.isShoppingCartDisplayed());
        Assert.assertEquals(cartPage.getProductPrice(productName), "$49.99");
        Assert.assertEquals(cartPage.getProductDescription(productName), "It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.");
        Assert.assertEquals(cartPage.getProductPrice(productName2), "$29.99");
        Assert.assertEquals(cartPage.getProductDescription(productName2), "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.");
        CartPage.getCartBadge();
        Assert.assertEquals(CartPage.getCartBadge(), "2");
        CartPage.clickRemoveButton(productName2);
        Assert.assertEquals(CartPage.getCartBadge(), "1");
        CartPage.clickCheckoutButton();
        Assert.assertTrue(cartPage.showCheckoutInfo(), "Checkout: Your Information");
    }
}