package helpers;

import managers.AppManager;
import pages.PageManager;

public class SearchHelper extends PageManager {

    public SearchHelper() {
        super(AppManager.getWebDriver());
    }

    public void searchForRepo(String text) {
        searchPage.searchForRepository(text);
    }

    public void jumpToResults() {
        searchPage.jumpToResults();
    }

    public void selectFirstResult() { searchPage.selectFirstSearchResult(); }

    public void changeSort() {searchPage.changeSort();}

    public String getSearchFieldValue(){return searchPage.getSearchFieldValue(); }
}
