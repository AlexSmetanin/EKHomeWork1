import io.qameta.allure.Attachment;
import managers.AppManager;
import managers.SingletonAppManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

class BaseTest {

    AppManager app = SingletonAppManager.getInstance().manager;
    WebDriver driver = AppManager.getWebDriver();

    @BeforeSuite
    public void before() {
        driver.navigate().to("https://github.com");
        app.getUserHelper().loginAs("AlexSmetanin", "Printer!23");
        // assertEquals(app.getUserHelper().getUsername(), "@AlexSmetanin");
    }

    //TODO login in before method and logout in after method

    @AfterSuite
    public void tearDown() {
        AppManager.getWebDriver().quit();
    }


}
