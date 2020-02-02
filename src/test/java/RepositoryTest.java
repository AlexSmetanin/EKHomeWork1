import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static utility.CustomTestListener.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.apache.commons.lang3.RandomStringUtils;
import utility.CustomTestListener;

@Listeners({CustomTestListener.class})

public class RepositoryTest extends BaseTest {

    String randomString;

    @Description("Count the number of repositories in the current account and compare with the reference value")
    @Test
    public void repositoryCountTest() throws InterruptedException {
        assertEquals(app.getRepositoryHelper().repositoryCount(), 8);
    }

    @Description("Create new repository with name that generated randomly")
    @Test
    public void createNewRepositoryTest() {
        randomString = RandomStringUtils.randomAlphabetic(10);
        app.getRepositoryHelper().createNewPerository(randomString);
        assertTrue(driver.getCurrentUrl().contains(randomString));
        assertEquals(driver.getCurrentUrl(), "https://github.com/AlexSmetanin/"+randomString);
        assertEquals(app.getRepositoryHelper().getRepositoryName(), randomString);
    }

    @Description("Delete repository created in the previous test")
    @Test
    void deleteRepositoryTest() {
        app.getRepositoryHelper().deleteRepository(randomString);
        String successDeleteMessage = "Your repository \"AlexSmetanin/"+randomString+"\" was successfully deleted.";
        assertTrue(app.getRepositoryHelper().getDeleteMessage().contains(successDeleteMessage));
    }

    @Description("Search for repositories that contain the given word in the name, check that the URL contains this word")
    @Test
    public void searchRepositoryTest() {
        app.getSearchHelper().searchForRepo("Selenium");
        assertTrue(driver.getCurrentUrl().contains("q=Selenium"));
        assertEquals(driver.getCurrentUrl(), "https://github.com/search?q=Selenium");
        assertEquals(app.getSearchHelper().getSearchFieldValue(), "Selenium");
    }


}
