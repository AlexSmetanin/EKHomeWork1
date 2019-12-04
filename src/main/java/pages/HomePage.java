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

    public int repositoryCount() {
        wait.until(ExpectedConditions.visibilityOf(showMoreButton));
        showMoreButton.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wait.until(ExpectedConditions.invisibilityOf(showMoreButton));
        return repositoryList.size();
    }

}
