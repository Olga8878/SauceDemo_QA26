package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutTwoStepPage extends BasePage {
    private static final By FINISH_BUTTON = By.id("finish");

    public static void clickFinishButton() {
        driver.findElement(FINISH_BUTTON).click();
    }

    public CheckoutTwoStepPage(WebDriver driver) {
        super(driver);
    }
}
