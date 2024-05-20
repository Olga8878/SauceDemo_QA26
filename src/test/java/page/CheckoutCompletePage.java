package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage extends BasePage {
    private static final By EXPRESS_IMAGE = By.className("pony_express");
    private static final By BACK_HOME_BUTTON = By.id("back-to-products");
    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }
    public boolean isShowExpressImage() {
        return driver.findElement(EXPRESS_IMAGE).isDisplayed();
    }
    public void clickBackhomeButton() {
        driver.findElement(BACK_HOME_BUTTON).click();
    }
}
