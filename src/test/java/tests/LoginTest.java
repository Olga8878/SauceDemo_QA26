package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.LoginPage;
import utils.Retry;


public class LoginTest extends BaseTest {
    @Test(description = "Positive login test", groups = "Smoke")
    public void positiveLoginTest() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(productsPage.isShoppingCartDisplayed());
    }

    @DataProvider
    public Object[][] negativeLoginTestData() {
        return new Object[][]{
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"standard_user", "", "Epic sadface: Password is required"}

        };
    }

    @Test(description = "Negative loginForm test", groups = "Smoke", dataProvider = "negativeLoginTestData", retryAnalyzer = Retry.class)
    public void negativeLoginTestWrongEmail(String username, String password, String errorMessage) {
        loginPage.open();
        loginPage.login(username, password);
        Assert.assertEquals(loginPage.getErrorMessageText(), errorMessage);
    }

    @Test(description = "Negative test with the introduction of an incorrect password", groups = "Smoke")
    public void negativeLoginTestWrongPassword() {
        loginPage.open();
        loginPage.login("standard_user", "");
        Assert.assertEquals(loginPage.getErrorMessageText(), "Epic sadface: Password is required");
    }
}