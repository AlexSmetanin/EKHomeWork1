import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.apache.commons.lang3.RandomStringUtils;

public class Lesson4Test extends BaseTest {

    String randomString;

    @Test (priority=1)
    public void githubLoginTest() {
        driver.navigate().to("https://github.com");
        app.getUserHelper().loginAs("AlexSmetanin", "Printer!23");
        assertEquals(app.getUserHelper().getUsername(), "@AlexSmetanin");
    }

    @Test (priority=2)
    public void repositoryCountTest() throws InterruptedException {
        assertEquals(8,app.getRepositoryHelper().repositoryCount());
    }

    @Test (priority=3)
    public void createNewRepositoryTest() {
        randomString = RandomStringUtils.randomAlphabetic(10);
        app.getRepositoryHelper().createNewPerository(randomString);
        assertTrue(driver.getCurrentUrl().contains(randomString));
        assertEquals(driver.getCurrentUrl(), "https://github.com/AlexSmetanin/"+randomString);
        assertEquals(app.getRepositoryHelper().getRepositoryName(), randomString);
    }

    @Test (priority=4)
    void deleteRepositoryTest() {
        app.getRepositoryHelper().deleteRepository(randomString);
        String successDeleteMessage = "Your repository \"AlexSmetanin/"+randomString+"\" was successfully deleted.";
        System.out.println(app.getRepositoryHelper().getDeleteMessage());
        assertTrue(app.getRepositoryHelper().getDeleteMessage().contains(successDeleteMessage));
    }

    @Test (priority=5)
    public void searchTest() {
        app.getRepositoryHelper().searchForRepo("Selenium");
        app.getRepositoryHelper().selectFirstResult();
        assertTrue(driver.getCurrentUrl().contains("q=Selenium"));
        https://github.com/search?q=Java
        assertEquals(driver.getCurrentUrl(), "https://github.com/search?q=Selenium");
        assertEquals(app.getRepositoryHelper().getSearchFieldValue(), "Selenium");
    }

}
