package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class PageManager {
    private WebDriver driver;
    protected GithubLoginPage githubLoginPage;
    protected HomePage homePage;
    protected SearchPage searchPage;

    public PageManager(WebDriver driver) {
        this.driver = driver;
        githubLoginPage = initElements(new GithubLoginPage(this));
        homePage = initElements(new HomePage(this));
        searchPage = initElements((new SearchPage(this)));
    }

    private <T extends Page> T initElements(T page) {
        PageFactory.initElements(driver, page);
        return page;
    }

    WebDriver getDriver() {
        return driver;
    }
}
