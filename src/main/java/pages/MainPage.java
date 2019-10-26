package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private WebDriverWait wait;

    public static final String avatarButtonLocator = "//div//summary//img[@class='avatar']";
    public static final String singOutButtonLocator = "(//button[contains(.,'Sign out')])[2]";

    public MainPage(WebDriver driver, WebDriverWait wait) {
        PageFactory.initElements(driver, this);
        this.wait = wait;
    }

    @FindBy(xpath = avatarButtonLocator)
    private WebElement avatarButton;
    @FindBy(xpath = singOutButtonLocator)
    private WebElement singOutButton;

    public String getUserName() {
        wait.until(ExpectedConditions.visibilityOf(avatarButton));
        return avatarButton.getAttribute("alt").toString().substring(1);
    }

    public void logOut() {
        avatarButton.click();
        wait.until(ExpectedConditions.visibilityOf(singOutButton));
        singOutButton.click();
    }

}