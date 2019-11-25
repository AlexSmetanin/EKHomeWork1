package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GithubLoginPage extends Page {

    GithubLoginPage(PageManager pages) {
        super(pages);
    }

    @FindBy(xpath = "//a[@href='/login']")
    private WebElement signInLink;

    @FindBy(xpath = "//input[@id='login_field']")
    private WebElement usernameField;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@name='commit']")
    private WebElement submitButton;

    @FindBy(xpath = "//img[@class='avatar']")
    private WebElement avatar;


    public void openLoginForm() {
        wait.until(ExpectedConditions.visibilityOf(signInLink));
        signInLink.click();
    }

    public void enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOf(usernameField));
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    public void enterPassword(String pass) {
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.clear();
        passwordField.sendKeys(pass);
    }

    public void submitLoginForm() {
        wait.until(ExpectedConditions.visibilityOf(submitButton));
        submitButton.click();
    }

    public String getUsername() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[@class='avatar']")));
        return avatar.getAttribute("alt");
    }

}
