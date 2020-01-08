package helpers;

import io.qameta.allure.Step;
import managers.AppManager;
import pages.PageManager;

public class SearchHelper extends PageManager {

    public SearchHelper() {
        super(AppManager.getWebDriver());
    }

    @Step("Search Github repository with string: {0}")
    public void searchForRepo(String text) {
        searchPage.searchForRepository(text);
        searchPage.jumpToResults();
    }

    public void selectFirstResult() { searchPage.selectFirstSearchResult(); }

    @Step("Count stars for each repository")
    public int countStars() {return searchPage.countStars();}

    @Step("Count repositories for language: {0}")
    public int countLanguages(String lang) { return searchPage.countLanguages(lang);}

    @Step("Change repositories sort method")
    public void changeSort() {searchPage.changeSort();}

    public String getSearchFieldValue(){return searchPage.getSearchFieldValue(); }
}
