package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.*;
public class CheckoutSecondStepTest extends BaseTest {
    @Test(description = "Check the completion of payment for purchases", groups = "Regression")
    public void clickFinishButton() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        String productName = "Sauce Labs Fleece Jacket";
        productsPage.clickAddCartButton(productName);
        cartPage.clickCartLink();
        cartPage.clickCheckoutButton();
        checkoutFirstStepPage.checkout("Olga", "Alekseychik", "11111");
        checkoutSecondStepPage.clickFinishButton();
        Assert.assertTrue(checkoutCompletePage.isShowExpressImage());
    }
}

