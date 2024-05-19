package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.*;

public class CheckoutCompleteTest extends BaseTest {
    @Test
    public void backToProductTest() {
        loginPage.open();
        LoginPage.login("standard_user", "secret_sauce");
        String productName = "Sauce Labs Fleece Jacket";
        productsPage.clickAddCartButton(productName);
        CartPage.clickCartLink();
        CartPage.clickCheckoutButton();
        CheckoutFirstStepPage.checkout("Olga", "Alekseychik", "11111");
        CheckoutSecondStepPage.clickFinishButton();
        CheckoutCompletePage.isShowExpressImage();
        Assert.assertTrue(CheckoutCompletePage.isShowExpressImage());
        CheckoutCompletePage.clickBackhomeButton();
        Assert.assertTrue(productsPage.isShoppingCartDisplayed());
    }
}

