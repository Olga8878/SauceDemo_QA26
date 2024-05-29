package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.AllureUtils;

public class CheckoutSecondStepPage extends BasePage {
    private static final By FINISH_BUTTON = By.id("finish");

    @Step("Click on the 'Finish button' button")
    public void clickFinishButton() {
        AllureUtils.attachScreenshot(driver);
        driver.findElement(FINISH_BUTTON).click();
    }
    public CheckoutSecondStepPage(WebDriver driver) {
        super(driver);
    }
}
