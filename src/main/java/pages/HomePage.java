package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HomePage extends Page {

    public HomePage(PageManager pages) {
        super(pages);
    }

    @FindBy(xpath = "//button[contains(.,'Show more')]")
        private WebElement showMoreButton;

    @FindBy(xpath = "//ul[@data-filterable-for='dashboard-repos-filter-left']/li")
        private List<WebElement> repositoryList;

    @FindBy(xpath = "//a[contains(.,'About')]")
        private WebElement aboutButton;

    @FindBy(xpath = "//a[@href='https://www.twitter.com/github']")
    private WebElement followAsOnTwitterButton;

    @FindBy(xpath = "//a[@href='/help/verified']/../../a")
    private WebElement twitterName;

    @FindBy(xpath = "//a[@href='/help/verified']")
    private WebElement verifiedIcon;

    public int repositoryCount() {
        wait.until(ExpectedConditions.visibilityOf(showMoreButton));
        showMoreButton.click();
        try {
            Thread.sleep(2000); //TODO check how to remove hard sleep
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wait.until(ExpectedConditions.invisibilityOf(showMoreButton));
        return repositoryList.size();
    }

    public void goToAbout() {
        wait.until(ExpectedConditions.visibilityOf(aboutButton));
        aboutButton.click();
    }

    public void clickFollowUsOnTwitterButton() {
        wait.until(ExpectedConditions.visibilityOf(followAsOnTwitterButton));
        followAsOnTwitterButton.click();
    }

    public String checkTwitterName(){
        wait.until(ExpectedConditions.visibilityOf(twitterName));
        return twitterName.getText();
    }

    public boolean checkVerified(){
        wait.until(ExpectedConditions.visibilityOf(verifiedIcon));
        return verifiedIcon.isDisplayed();
    }
}
