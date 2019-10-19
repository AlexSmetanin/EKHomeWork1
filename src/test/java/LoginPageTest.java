import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginPageTest extends BaseTest {

    private By signInLink = By.xpath("//a[@href='/login']");
    private By usernameField = By.xpath("//input[@id='login_field']");
    private By passwordField = By.xpath("//input[@id='password']");
    private By submitButton = By.xpath("//input[@name='commit']");
    private By avatarButton = By.xpath("//div//summary//img[@class='avatar']");
    private By singOutButton = By.xpath(("(//button[contains(.,'Sign out')])[2]"));

    @Test(dataProvider = "getCredentials")
    public void login(String url, String login, String password) {
        driver.navigate().to(url);
        driver.findElement(signInLink).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(submitButton));
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

}