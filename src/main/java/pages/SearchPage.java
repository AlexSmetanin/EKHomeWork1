package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Random;

public class SearchPage extends Page {

    SearchPage(PageManager pages) {
        super(pages);
    }

    public static final String searchFieldLocator = "//input[@name='q']";
    public static final String jumpToResultsLocator = "(id('jump-to-results')/li)[2]";
    public static final String firstSearchResultLocator = "((//*[@class='repo-list']/li)[1])/div/div/a";
    public static final String changeSortDropdownLocator = "//summary/i";
    public static final String changeSortOptionLocator = "//div[@class='select-menu-list']/a";

    @FindBy(xpath = searchFieldLocator)
    private WebElement searchField;

    @FindBy(xpath = jumpToResultsLocator)
    private WebElement jumpToResults;

    @FindBy(xpath = firstSearchResultLocator)
    private WebElement firstSearchResult;

    @FindBy(xpath = changeSortDropdownLocator)
    private WebElement changeSortDropdown;

    @FindBy(xpath = changeSortOptionLocator)
    private List<WebElement> changeSortOption;

    public void searchForRepository(String text) {
        wait.until(ExpectedConditions.visibilityOf(searchField));
        searchField.clear();
        searchField.sendKeys(text);
    }

    public String getSearchFieldValue() {
        wait.until(ExpectedConditions.visibilityOf(searchField));
        return searchField.getAttribute("value");
    }

    public void jumpToResults() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(jumpToResultsLocator)));
        jumpToResults.click();
    }

    public void selectFirstSearchResult() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(firstSearchResultLocator)));
        firstSearchResult.click();
    }

    public void changeSort() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(changeSortDropdownLocator)));
        changeSortDropdown.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(changeSortOptionLocator)));
        changeSortOption.get(new Random().nextInt(7)).click();
    }


}
