import lesson4.managers.AppManager;
import lesson4.managers.SingletonAppManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

class BaseTest {

    AppManager app = SingletonAppManager.getInstance().manager;
    WebDriver driver = AppManager.getWebDriver();

    @BeforeSuite
    public void before() {
    }

    @AfterSuite
    public void tearDown() {
        AppManager.getWebDriver().quit();
    }


}
