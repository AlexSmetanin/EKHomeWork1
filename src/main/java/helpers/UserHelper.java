package helpers;

import managers.AppManager;
import pages.PageManager;


public class UserHelper extends PageManager {

    public UserHelper() {
        super(AppManager.getWebDriver());
    }

    public void loginAs(String username, String pass){
        githubLoginPage.openLoginForm();
        githubLoginPage.enterUsername(username);
        githubLoginPage.enterPassword(pass);
        githubLoginPage.submitLoginForm();
    }

    public String getUsername() {return githubLoginPage.getUsername();}
}

