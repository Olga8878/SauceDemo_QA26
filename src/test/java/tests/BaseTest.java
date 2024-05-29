package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import page.*;
import utils.DriverFactory;
import utils.InvokedListener;
import utils.TestListener;

import java.time.Duration;

@Listeners({InvokedListener.class})
public abstract class BaseTest {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected ProductsPage productsPage;
    protected CheckoutFirstStepPage checkoutFirstStepPage;
    protected CheckoutSecondStepPage checkoutSecondStepPage;
    protected CheckoutCompletePage checkoutCompletePage;
    protected CartPage cartPage;

    @BeforeMethod(alwaysRun = true)
    @Parameters({"browserName"})
    public void setUp(@Optional("chrome") String browser, ITestContext testContext) throws Exception {
        driver = DriverFactory.getDriver(browser);
        testContext.setAttribute("driver", driver);
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
