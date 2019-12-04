package helpers;

import managers.AppManager;
import pages.PageManager;

public class SearchHelper extends PageManager {

    public SearchHelper() {
        super(AppManager.getWebDriver());
    }


}
