package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.*;

public class CheckoutTwoStepTest extends BaseTest {
    @Test
    public void clickFinishButton()  {
        loginPage.open();
        LoginPage.login("standard_user", "secret_sauce");
        String productName = "Sauce Labs Fleece Jacket";
        productsPage.clickAddCartButton(productName);

        CartPage.clickCartLink();
        CartPage.clickCheckoutButton();

        CheckoutOneStepPage.checkout("Olga", "Alekseychik", "11111");

        CheckoutTwoStepPage.clickFinishButton();
        Assert.assertTrue(CheckoutCompletePage.isShowExpressImage());

    }
}

