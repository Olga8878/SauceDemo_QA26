package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage extends BasePage {
    private final static String ITEM_CONTAINER = "//div[text()='%s']/ancestor::div[@class='inventory_item']";
    private static final By SHOPPING_CARD = By.className(("shopping_cart_link"));
    private final static By ADD_TO_CART_BUTTON = By.cssSelector("button[id^=add-to-cart]");
    private final static By ITEM_PRICE = By.className("inventory_item_price");
    private final static By ITEM_DESCRIPTION = By.className("inventory_item_desc");


    public ProductsPage(WebDriver driver) {
        super(driver);
    }
    public boolean isShoppingCartDisplayed() {
        return driver.findElement(SHOPPING_CARD).isDisplayed();
    }
    public void clickAddCartButton(String productName) {
        this.getProductCardByName(productName).findElement(ADD_TO_CART_BUTTON).click();
    }
    public String getProductPrice(String productName) {
        return this.getProductCardByName(productName).findElement(ITEM_PRICE).getText();
    }
    public String getProductDescription(String productName) {
        return this.getProductCardByName(productName).findElement(ITEM_DESCRIPTION).getText();
    }
    private WebElement getProductCardByName(String productName) {
        return driver.findElement(By.xpath(String.format(ITEM_CONTAINER, productName)));
    }
}

