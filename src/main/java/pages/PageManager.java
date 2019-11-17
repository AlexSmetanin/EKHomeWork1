package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class PageManager {
    private WebDriver driver;

    public PageManager(WebDriver driver) {
        this.driver = driver;
    }

    private <T extends Page> T initElements(T page) {
        PageFactory.initElements(driver, page);
        return page;
    }

    WebDriver getDriver() { return driver;}
}
