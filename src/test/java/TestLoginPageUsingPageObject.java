import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestLoginPageUsingPageObject extends BaseTest {

    @Test(dataProvider = "getCredentials")
    public void login(String login, String password) {
        String url = System.getProperty("base.url");
        driver.navigate().to(url);

        homePage.logIn(login, password);
        assertEquals(login, mainPage.getUserName());

        mainPage.goToBlogPage();
        assertEquals(blogPage.getURL(driver),"https://github.blog/");
        assertEquals(blogPage.getTitle(driver),"The GitHub Blog");
        assertEquals(blogPage.getLogoTitile(), "The GitHub Blog");
    }

}