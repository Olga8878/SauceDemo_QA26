package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOneStepPage extends BasePage {
    private static final By FIRST_NAME_FIELD = By.id("first-name");
    private static final By LAST_NAME_FIELD = By.id("last-name");
    private static final By INPUT_ZIP = By.id("postal-code");
    private static final By ITEM_TOTAL = By.className("summary_subtotal_label");
    private static final By CONTINUE_BUTTON = By.id("continue");
    private static final By CART_LINK = By.className("shopping_cart_link");

    public CheckoutOneStepPage(WebDriver driver) {
        super(driver);
    }

    private static void inputFirstName(String firstname) {
        driver.findElement(FIRST_NAME_FIELD).sendKeys(firstname);
    }

    private static void inputLastName(String lastname) {
        driver.findElement(LAST_NAME_FIELD).sendKeys(lastname);
    }

    private static void inputZipCode(String zipcode) {
        driver.findElement(INPUT_ZIP).sendKeys(zipcode);
    }

    public static String getItemTotal() {
        return driver.findElement(ITEM_TOTAL).getText();

    }


    private static void clickContinueButton() {
        driver.findElement(CONTINUE_BUTTON).click();

    }

    public static void clickCartLink() {
        driver.findElement(CART_LINK).click();

    }


    public static void checkout(String firstname, String lastname, String zipcode) {
        inputFirstName(firstname);
        inputLastName(lastname);
        inputZipCode(zipcode);
        clickContinueButton();
    }

}

