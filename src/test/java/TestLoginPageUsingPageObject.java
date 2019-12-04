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

    @Test(dataProvider = "getCredentials")
    public void filesCount(String login, String password){
        String url = System.getProperty("base.url");
        driver.navigate().to(url);

        homePage.logIn(login, password);

        driver.navigate().to("https://github.com/AlexSmetanin/HomeWork2");
        System.out.println("You have " + homeWorkPage.getUserFilesCount() + " files and directories");
    }

    @Test(dataProvider = "getCredentials")
    public void filesAndFoldersCount(String login, String password){
        String url = System.getProperty("base.url");
        driver.navigate().to(url);

        homePage.logIn(login, password);

        driver.navigate().to("https://github.com/AlexSmetanin/HomeWork2");
        assertEquals(3,homeWorkPage.getUserDirectoryOnlyCount());
        assertEquals(3,homeWorkPage.getUserFilesOnlyCount());
    }

}