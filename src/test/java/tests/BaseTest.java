package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.*;
import java.time.Duration;

public abstract class BaseTest {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected ProductsPage productsPage;
    protected CheckoutFirstStepPage checkoutFirstStepPage;
    protected CheckoutSecondStepPage checkoutSecondStepPage;
    protected CheckoutCompletePage checkoutCompletePage;
    protected CartPage cartPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        this.driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        this.loginPage = new LoginPage(driver);
        this.productsPage = new ProductsPage(driver);
        this.checkoutFirstStepPage = new CheckoutFirstStepPage(driver);
        this.checkoutSecondStepPage = new CheckoutSecondStepPage(driver);
        this.checkoutCompletePage = new CheckoutCompletePage(driver);
        this.cartPage = new CartPage(driver);
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        this.driver.quit();
    }
}
