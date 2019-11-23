package managers;

import helpers.RepositoryHelper;
import helpers.UserHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class AppManager {

    private UserHelper userHelper;
    private RepositoryHelper repositoryHelper;

    private static WebDriver driver;

    AppManager() {
        File chromeDriver = new File(System.getProperty("chrome.driver.path"));
        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(chromeDriver)
                .usingAnyFreePort()
                .build();
        ChromeOptions options = new ChromeOptions().addArguments("--windows-size=1920,1080");
        driver = new ChromeDriver(service,options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        userHelper = new UserHelper();
        repositoryHelper = new RepositoryHelper();
    }

    public static WebDriver getWebDriver() { return driver;}

    public UserHelper getUserHelper() {return userHelper;}

    public RepositoryHelper getRepositoryHelper() {return repositoryHelper;}

}
