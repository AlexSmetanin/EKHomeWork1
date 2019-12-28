package helpers;

import managers.AppManager;
import pages.PageManager;

public class SearchHelper extends PageManager {

    public SearchHelper() {
        super(AppManager.getWebDriver());
    }

    public void searchForRepo(String text) {
        searchPage.searchForRepository(text);
        searchPage.jumpToResults();
    }

    public void selectFirstResult() { searchPage.selectFirstSearchResult(); }

    public int countStars() {return searchPage.countStars();}

    public int countLanguages(String lang) { return searchPage.countLanguages(lang);}

    public void changeSort() {searchPage.changeSort();}

    public String getSearchFieldValue(){return searchPage.getSearchFieldValue(); }
}
