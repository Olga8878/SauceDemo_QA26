package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {


    private static final By CONTINUE_SHOPPING_BUTTON = By.id("continue-shopping");
    private static final By CHECKOUT_BUTTON = By.id("checkout");
    private static final By CART_LINK = By.className("shopping_cart_link");
    private static final By CHECKOUT_INFO = By.className("checkout_info");

    public CartPage(WebDriver driver) {
        super(driver);

    }


    public static void clickCheckoutButton() {
        driver.findElement(CHECKOUT_BUTTON).click();

    }


    public void clickContinueShopping() {
        driver.findElement(CONTINUE_SHOPPING_BUTTON).click();

    }

    public static void clickCartLink() {
        driver.findElement(CART_LINK).click();
    }

    public boolean showCheckoutInfo() {
        return driver.findElement(CHECKOUT_INFO).isDisplayed();
    }
}
