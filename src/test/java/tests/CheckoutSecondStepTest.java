package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.*;
public class CheckoutSecondStepTest extends BaseTest {
    @Test
    public void clickFinishButton() {
        loginPage.open();
        LoginPage.login("standard_user", "secret_sauce");
        String productName = "Sauce Labs Fleece Jacket";
        productsPage.clickAddCartButton(productName);
        CartPage.clickCartLink();
        CartPage.clickCheckoutButton();
        CheckoutFirstStepPage.checkout("Olga", "Alekseychik", "11111");
        CheckoutSecondStepPage.clickFinishButton();
        Assert.assertTrue(CheckoutCompletePage.isShowExpressImage());
    }
}

