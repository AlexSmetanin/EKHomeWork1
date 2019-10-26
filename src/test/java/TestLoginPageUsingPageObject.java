import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestLoginPageUsingPageObject extends BaseTest {

    @Test(dataProvider = "getCredentials")
    public void login(String url, String login, String password) {
        driver.navigate().to(url);
        homePage.logIn(login, password);
        assertEquals(login, mainPage.getUserName());
        mainPage.logOut();
    }

}