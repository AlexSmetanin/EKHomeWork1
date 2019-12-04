package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BlogPage {
    private WebDriverWait wait;

    public BlogPage(WebDriver driver, WebDriverWait wait) {
        PageFactory.initElements(driver, this);
        this.wait = wait;
    }

    public static final String logoTitleLocator = "//h1";

    @FindBy(xpath = logoTitleLocator)
    private WebElement logoTitle;


    public String getTitle(WebDriver driver) {
        return driver.getTitle().substring(0, 15);
    }

    public String getURL(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public String getLogoTitile() {
        wait.until(ExpectedConditions.visibilityOf(logoTitle));
        return logoTitle.getText();
    }
}
