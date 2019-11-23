package helpers;

import managers.AppManager;
import pages.PageManager;

public class RepositoryHelper extends PageManager {

    public RepositoryHelper() {
        super(AppManager.getWebDriver());
    }

    public int repositoryCount() {return homePage.repositoryCount();}

    public void createNewPerository(String repositoryName){
        repositoryPage.openCreateRepositoryForm();
        repositoryPage.enterRepositoryName(repositoryName);
        repositoryPage.submitCreateForm();
    }

    public String getRepositoryName(){
        return repositoryPage.getRepositoryName();
    }

    public void deleteRepository(String repositoryName) {
        repositoryPage.openSettingsForm();
        repositoryPage.deleteRepository();
        repositoryPage.inputDeleteRepositoryName(repositoryName);
        repositoryPage.submitDeleteRepositoryForm();
    }

    public String getDeleteMessage(){
        return repositoryPage.getDeleteMessage();
    }

    public void searchForRepo(String text) {
        homePage.searchForRepository(text);
    }
    public void selectFirstResult() {
        searchPage.selectFirstSearchResult();
    }
    public String getSearchFieldValue(){
        return homePage.getSearchFieldValue();
    }

}
