package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private static final By EMAIL_INPUT = By.id("user-name");
    private static final By PASSWORD_INPUT = By.id("password");
    private static final By LOGIN_BUTTON = By.id("login-button");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public static void setEmailValue(String email) {
        driver.findElement(EMAIL_INPUT).sendKeys(email);
    }

    public static void setPasswordValue(String password) {
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
    }

    public static void clickLoginButton() {
        driver.findElement(LOGIN_BUTTON).click();
    }
    public static void login(String email, String password) {
        setEmailValue(email);
        setPasswordValue(password);
        clickLoginButton();
    }
    public void open() {
        driver.get("https://www.saucedemo.com/");
    }
}


