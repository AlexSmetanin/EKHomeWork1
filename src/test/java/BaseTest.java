import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import pages.HomePage;
import pages.MainPage;

import java.io.File;
import java.util.concurrent.TimeUnit;

class BaseTest {

    WebDriver driver;
    HomePage homePage;
    MainPage mainPage;
    WebDriverWait wait;

    @BeforeSuite
    public void before() {
        File chromeDriver = new File(System.getProperty("chrome.driver.path"));  // new File(PropertyLoader.loadProperty("chrome.driver.path"));
        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(chromeDriver)
                .usingAnyFreePort()
                .build();
        ChromeOptions options = new ChromeOptions().addArguments("--window-size=1920,1080");
        driver = new ChromeDriver(service, options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
        homePage = new HomePage(driver, wait);
        mainPage = new MainPage(driver, wait);
    }

    @DataProvider
    public Object[][] getCredentials() {
        return new Object[][]{
                {"http://github.com", "AlexSmetanin", "Printer!23"},
        };
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }

}
