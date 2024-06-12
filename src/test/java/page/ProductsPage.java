package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.AllureUtils;

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
        AllureUtils.attachScreenshot(driver);
        return driver.findElement(SHOPPING_CARD).isDisplayed();
    }
    @Step("Click on the 'Add to Cart' button for the product {productName}")
    public void clickAddCartButton(String productName) {
        this.getProductCardByName(productName).findElement(ADD_TO_CART_BUTTON).click();
    }
    @Step("Getting the product price {productName}")
    public String getProductPrice(String productName) {
        return this.getProductCardByName(productName).findElement(ITEM_PRICE).getText();
    }
    @Step("Getting a product description {productName}")
    public String getProductDescription(String productName) {
        return this.getProductCardByName(productName).findElement(ITEM_DESCRIPTION).getText();
    }
    private WebElement getProductCardByName(String productName) {
        return driver.findElement(By.xpath(String.format(ITEM_CONTAINER, productName)));
    }
}

