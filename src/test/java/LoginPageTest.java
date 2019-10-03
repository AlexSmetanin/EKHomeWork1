import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

import static org.testng.Assert.assertEquals;

public class LoginPageTest {
    private WebDriver driver;
    private WebDriverWait wait;

    private By signInLink = By.xpath("//a[@href='/login']");
    private By usernameField = By.xpath("//input[@id='login_field']");
    private By passwordField = By.xpath("//input[@id='password']");
    private By submitButton = By.xpath("//input[@name='commit']");
    private By avatarButton = By.xpath("//div//summary//img[@class='avatar']");
    private By singOutButton = By.xpath(("(//button[contains(.,'Sign out')])[2]"));

    @BeforeClass
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver",
                new File(LoginPageTest.class.getResource("/chromedriver.exe").getFile()).getPath());
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 30);
    }

    @DataProvider
    public Object[][] getCredentials() {
        return new Object[][]{
                {"http://github.com", "AlexSmetanin", "Printer!23"},
        };
    }

    @Test(dataProvider = "getCredentials")
    public void login(String url, String login, String password) {
        driver.get(url);
        driver.manage().window().maximize();

        wait.until(ExpectedConditions.presenceOfElementLocated(signInLink));
        driver.findElement(signInLink).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(submitButton));
        driver.findElement(usernameField).sendKeys(login);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(submitButton).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(avatarButton));
        String userName = driver.findElement(avatarButton).getAttribute("alt").toString().substring(1);
        assertEquals(login, userName);

        driver.findElement(avatarButton).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(singOutButton));
        driver.findElement(singOutButton).click();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}