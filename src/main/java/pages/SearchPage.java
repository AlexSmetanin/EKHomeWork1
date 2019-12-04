package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchPage extends Page {

    SearchPage(PageManager pages) {
        super(pages);
    }

    public static final String jumpToResultsLocator = "(id('jump-to-results')/li)[2]";
    public static final String firstSearchResultLocator = "((//*[@class='repo-list']/li)[1])/div/div/a";

    @FindBy(xpath = jumpToResultsLocator)
    private WebElement jumpToResults;

    @FindBy(xpath = firstSearchResultLocator)
    private WebElement firstSearchResult;


    public void jumpToResults() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(jumpToResultsLocator)));
        jumpToResults.click();
    }

    public void selectFirstSearchResult() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(firstSearchResultLocator)));
        firstSearchResult.click();
    }
}
