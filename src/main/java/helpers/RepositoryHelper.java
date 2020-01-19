package helpers;

import io.qameta.allure.Step;
import managers.AppManager;
import pages.PageManager;

public class RepositoryHelper extends PageManager {

    public RepositoryHelper() {
        super(AppManager.getWebDriver());
    }

    @Step("Count repositories from repository list")
    public int repositoryCount() {return homePage.repositoryCount();}

    @Step("Create new repository with name: {0}")
    public void createNewPerository(String repositoryName){
        repositoryPage.openCreateRepositoryForm();
        repositoryPage.enterRepositoryName(repositoryName);
        repositoryPage.submitCreateForm();
    }

    @Step("Get new repository name from repository page")
    public String getRepositoryName(){
        return repositoryPage.getRepositoryName();
    }

    @Step("Delete repository with name: {0}")
    public void deleteRepository(String repositoryName) {
        repositoryPage.openSettingsForm();
        repositoryPage.deleteRepository();
        repositoryPage.inputDeleteRepositoryName(repositoryName);
        repositoryPage.submitDeleteRepositoryForm();
    }

    @Step("Check that repository was deleted")
    public String getDeleteMessage(){
        return repositoryPage.getDeleteMessage();
    }

}
