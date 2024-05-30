package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.AllureUtils;

public class CartPage extends BasePage {
    private static final By CHECKOUT_BUTTON = By.id("checkout");
    private static final By CART_LINK = By.className("shopping_cart_link");
    private static final By CHECKOUT_INFO = By.className("checkout_info");
    private final static By REMOVE_TO_CART_BUTTON = By.cssSelector("button[id^=remove]");
    private final static String ITEM_CONTAINER = "//div[text()='%s']/ancestor::div[@class='cart_item_label']";
    private final static By ITEM_PRICE = By.className("inventory_item_price");
    private final static By ITEM_DESCRIPTION = By.className("inventory_item_desc");
    private final static By SHOPPING_CART_BADGE = By.className("shopping_cart_badge");
    public CartPage(WebDriver driver) {
        super(driver);
    }
    @Step("Click on Checkout button")
    public void clickCheckoutButton() {
        driver.findElement(CHECKOUT_BUTTON).click();
    }

    @Step("Get shopping cart badge")
    public String getCartBadge() {
        return driver.findElement(SHOPPING_CART_BADGE).getText();
    }

    @Step("Click on Cart link")
    public void clickCartLink() {
        driver.findElement(CART_LINK).click();
    }

    public boolean showCheckoutInfo() {
        AllureUtils.attachScreenshot(driver);
        return driver.findElement(CHECKOUT_INFO).isDisplayed();
    }
    @Step("Click on Remove button for product: {productName}")
    public void clickRemoveButton(String productName) {
        driver.findElement(REMOVE_TO_CART_BUTTON).click();
    }

    private WebElement getProductCardByName(String productName) {
        return driver.findElement(By.xpath(String.format(ITEM_CONTAINER, productName)));
    }
    @Step("Get price for product: {productName}")
    public String getProductPrice(String productName) {
        return this.getProductCardByName(productName).findElement(ITEM_PRICE).getText();
    }
    @Step("Get description for product: {productName}")
    public String getProductDescription(String productName) {
        return this.getProductCardByName(productName).findElement(ITEM_DESCRIPTION).getText();
    }
}


