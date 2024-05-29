package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.CartPage;
import page.CheckoutFirstStepPage;
import page.LoginPage;
public class CheckoutFirstStepTest extends BaseTest {
        @Test(description = "Check the input of payment information", groups = "Smoke")
        public void inputCardInformationTest() {
                loginPage.open();
                loginPage.login("standard_user", "secret_sauce");
                String productName = "Sauce Labs Fleece Jacket";
                productsPage.clickAddCartButton(productName);
                cartPage.clickCartLink();
                cartPage.clickCheckoutButton();
                checkoutFirstStepPage.checkout("Olga", "Alekseychik", "11111");
                Assert.assertEquals(checkoutFirstStepPage.getItemTotal(), "Item total: $49.99");
        }
}


