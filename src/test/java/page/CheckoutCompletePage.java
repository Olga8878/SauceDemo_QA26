package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.AllureUtils;

public class CheckoutCompletePage extends BasePage {
    private static final By EXPRESS_IMAGE = By.className("pony_express");
    private static final By BACK_HOME_BUTTON = By.id("back-to-products");

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    public boolean isShowExpressImage() {
        AllureUtils.attachScreenshot(driver);
        return driver.findElement(EXPRESS_IMAGE).isDisplayed();
    }
    @Step("Click on Back to Home button")
    public void clickBackhomeButton() {
        driver.findElement(BACK_HOME_BUTTON).click();
    }
}
