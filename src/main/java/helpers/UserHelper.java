package helpers;

import io.qameta.allure.Step;
import managers.AppManager;
import pages.PageManager;


public class UserHelper extends PageManager {

    public UserHelper() {
        super(AppManager.getWebDriver());
    }

    @Step("Login to Github with username: {0}, password: {1}")
    public void loginAs(String username, String pass){
        githubLoginPage.openLoginForm();
        githubLoginPage.enterUsername(username);
        githubLoginPage.enterPassword(pass);
        githubLoginPage.submitLoginForm();
    }

    @Step("Return Github username")
    public String getUsername() {return githubLoginPage.getUsername();}
}

