package lesson4.helpers;

import lesson4.managers.AppManager;
import pages.PageManager;


public class UserHelper extends PageManager {

    public UserHelper() {
        super(AppManager.getWebDriver());
    }

}

