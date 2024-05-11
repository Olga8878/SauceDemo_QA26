package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.LoginPage;
import page.ProductsPage;

public class LoginTest extends BaseTest {
    @Test
    public void positiveLoginTest() throws InterruptedException {
        loginPage.open();

        LoginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(productsPage.isShoppingCartDisplayed());
        Thread.sleep(3000);




    }

}
