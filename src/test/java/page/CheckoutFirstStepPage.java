package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.AllureUtils;

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

    @Step("Entering the name '{firstname}' in the 'First Name' field")
    private void inputFirstName(String firstname) {
        driver.findElement(FIRST_NAME_FIELD).sendKeys(firstname);
    }

    @Step("Entering the last name '{lastname}' in the 'Last Name' field")
    private void inputLastName(String lastname) {
        driver.findElement(LAST_NAME_FIELD).sendKeys(lastname);
    }

    @Step("Entering the zip code '{zipcode}' in the 'Postal Code' field")
    private void inputZipCode(String zipcode) {
        driver.findElement(INPUT_ZIP).sendKeys(zipcode);
    }

    @Step("Getting the total amount")
    public String getItemTotal() {
        return driver.findElement(ITEM_TOTAL).getText();
    }

    @Step("Click on the 'Continue' button")
    private void clickContinueButton() {
        driver.findElement(CONTINUE_BUTTON).click();
    }

    @Step("Click on the 'Cart' link")
    public void clickCartLink() {
        driver.findElement(CART_LINK).click();
    }

    @Step("Filling out the form with the name '{firstname}', last name '{lastname}' and zip code '{zipcode}'" +
            " and moving on to the next step")
    public void checkout(String firstname, String lastname, String zipcode) {
        AllureUtils.attachScreenshot(driver);
        inputFirstName(firstname);
        inputLastName(lastname);
        inputZipCode(zipcode);
        clickContinueButton();
    }
}

