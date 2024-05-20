package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutFirstStepPage extends BasePage {
    private static final By FIRST_NAME_FIELD = By.id("first-name");
    private static final By LAST_NAME_FIELD = By.id("last-name");
    private static final By INPUT_ZIP = By.id("postal-code");
    private static final By ITEM_TOTAL = By.className("summary_subtotal_label");
    private static final By CONTINUE_BUTTON = By.id("continue");
    private static final By CART_LINK = By.className("shopping_cart_link");

    public CheckoutFirstStepPage(WebDriver driver) {
        super(driver);
    }
    private void inputFirstName(String firstname) {
        driver.findElement(FIRST_NAME_FIELD).sendKeys(firstname);
    }
    private void inputLastName(String lastname) {
        driver.findElement(LAST_NAME_FIELD).sendKeys(lastname);
    }
    private void inputZipCode(String zipcode) {
        driver.findElement(INPUT_ZIP).sendKeys(zipcode);
    }
    public String getItemTotal() {
        return driver.findElement(ITEM_TOTAL).getText();
    }
    private void clickContinueButton() {
        driver.findElement(CONTINUE_BUTTON).click();
    }
    public void clickCartLink() {
        driver.findElement(CART_LINK).click();
    }
    public void checkout(String firstname, String lastname, String zipcode) {
        inputFirstName(firstname);
        inputLastName(lastname);
        inputZipCode(zipcode);
        clickContinueButton();
    }
}

