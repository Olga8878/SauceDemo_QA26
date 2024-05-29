package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;
import page.*;
import utils.TestListener;

import java.time.Duration;

@Listeners({TestListener.class})
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
    public void setUp(@Optional("chrome") String browser) throws Exception {
        if (browser.equals("chrome")) {
            this.driver = new ChromeDriver();
        } else if (browser.equals("microsoft edge")) {
            this.driver = new EdgeDriver();
        } else {
            throw new Exception("Unsupported browser");
        }
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
