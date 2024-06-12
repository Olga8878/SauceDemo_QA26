package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.AllureUtils;

public class LoginPage extends BasePage {
    private static final By EMAIL_INPUT = By.id("user-name");
    private static final By PASSWORD_INPUT = By.id("password");
    private static final By LOGIN_BUTTON = By.id("login-button");
    private static final By ERROR_MESSAGE = By.cssSelector("h3[data-test=error]");
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Getting the error message text")
    public String getErrorMessageText() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }
    @Step("Entering the value '{email}' in the 'Email' field")
    public void setEmailValue(String email) {
        driver.findElement(EMAIL_INPUT).sendKeys(email);
    }

    @Step("Entering the value '{password}' in the field 'Password'")
    public void setPasswordValue(String password) {
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
    }

    @Step("Click on the 'Login' button")
    public void clickLoginButton() {
        driver.findElement(LOGIN_BUTTON).click();
    }

    @Step("Logging in with email '{email}' and password '{password}'")
    public void login(String email, String password) {
        AllureUtils.attachScreenshot(driver);
        setEmailValue(email);
        setPasswordValue(password);
        clickLoginButton();
    }
    public void open() {
        driver.get("https://www.saucedemo.com/");
    }
}


