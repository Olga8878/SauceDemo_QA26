package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
    public void clickCheckoutButton() {
        driver.findElement(CHECKOUT_BUTTON).click();
    }
     public String getCartBadge() {
         return driver.findElement(SHOPPING_CART_BADGE).getText();
     }
    public void clickCartLink() {
        driver.findElement(CART_LINK).click();
    }
    public boolean showCheckoutInfo() {
        return driver.findElement(CHECKOUT_INFO).isDisplayed();
    }
    public void clickRemoveButton(String productName) {
        driver.findElement(REMOVE_TO_CART_BUTTON).click();
    }
    private WebElement getProductCardByName(String productName) {
        return driver.findElement(By.xpath(String.format(ITEM_CONTAINER, productName)));
    }
    public String getProductPrice (String productName) {
        return this.getProductCardByName(productName).findElement(ITEM_PRICE ).getText();
    }
    public String getProductDescription (String productName) {
        return this.getProductCardByName(productName).findElement(ITEM_DESCRIPTION).getText();
    }
}


