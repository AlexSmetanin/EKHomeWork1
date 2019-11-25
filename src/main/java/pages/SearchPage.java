package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchPage extends Page {

    SearchPage(PageManager pages) {
        super(pages);
    }

    public static final String firstSearchResultLocator = "(id('jump-to-results')/li)[2]";

    @FindBy(xpath = firstSearchResultLocator)
    private WebElement firstSearchResult;

    public void selectFirstSearchResult() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(firstSearchResultLocator)));
        firstSearchResult.click();
    }
}
