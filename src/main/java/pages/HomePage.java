package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriverWait wait;

    public static final String signInLinkLocator = "//a[@href='/login']";
    public static final String usernameFieldLocator = "//input[@id='login_field']";
    public static final String passwordFieldLocator = "//input[@id='password']";
    public static final String submitButtonLocator = "//input[@name='commit']";

    public HomePage(WebDriver driver, WebDriverWait wait) {
        PageFactory.initElements(driver, this);
        this.wait = wait;
    }

    @FindBy(xpath = signInLinkLocator)
    private WebElement signInLink;
    @FindBy(xpath = usernameFieldLocator)
    private WebElement usernameField;
    @FindBy(xpath = passwordFieldLocator)
    private WebElement passwordField;
    @FindBy(xpath = submitButtonLocator)
    private WebElement submitButton;

    public void logIn(String login, String password) {
        wait.until(ExpectedConditions.visibilityOf(signInLink));
        signInLink.click();
        usernameField.clear();
        usernameField.sendKeys(login);
        passwordField.clear();
        passwordField.sendKeys(password);
        submitButton.click();
    }
}
