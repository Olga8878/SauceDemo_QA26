package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.CartPage;
import page.CheckoutFirstStepPage;
import page.LoginPage;
public class CheckoutFirstStepTest extends BaseTest {
        @Test
        public void inputCardInformationTest() {
                loginPage.open();
                LoginPage.login("standard_user", "secret_sauce");
                String productName = "Sauce Labs Fleece Jacket";
                productsPage.clickAddCartButton(productName);
                CartPage.clickCartLink();
                CartPage.clickCheckoutButton();
                CheckoutFirstStepPage.checkout("Olga", "Alekseychik", "11111");
                Assert.assertEquals(CheckoutFirstStepPage.getItemTotal(), "Item total: $49.99");
        }
}


