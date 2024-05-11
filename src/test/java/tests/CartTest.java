package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.CartPage;
import page.LoginPage;

public class CartTest extends BaseTest {
    @Test
    public void clickContinueShoppingCart() {

        loginPage.open();
        LoginPage.login("standard_user", "secret_sauce");
        CartPage.clickCartLink();

        cartPage.clickContinueShopping();
        Assert.assertTrue(productsPage.isShoppingCartDisplayed());


    }

    @Test
    public void clickCheckoutButton() throws InterruptedException {

        loginPage.open();
        LoginPage.login("standard_user", "secret_sauce");
        CartPage.clickCartLink();
        CartPage.clickCheckoutButton();
        Assert.assertTrue(cartPage.showCheckoutInfo());


    }
}