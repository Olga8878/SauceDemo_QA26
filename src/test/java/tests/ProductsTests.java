package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.CartPage;
import page.LoginPage;

public class ProductsTests extends BaseTest {
    @Test(description = "Check the addition of an item to the shopping cart", groups = "Smoke")
    public void addToCartProductTest() {
        loginPage.open();
        String productName = "Sauce Labs Fleece Jacket";
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertEquals(productsPage.getProductPrice(productName), "$49.99");
        Assert.assertEquals(productsPage.getProductDescription(productName), "It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.");
        productsPage.clickAddCartButton(productName);
        cartPage.getCartBadge();
        Assert.assertEquals(cartPage.getCartBadge(), "1");
    }
}
