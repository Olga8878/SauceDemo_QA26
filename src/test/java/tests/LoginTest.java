package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.LoginPage;
public class LoginTest extends BaseTest {
    @Test
    public void positiveLoginTest() {
        loginPage.open();
        LoginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(productsPage.isShoppingCartDisplayed());
    }
}
