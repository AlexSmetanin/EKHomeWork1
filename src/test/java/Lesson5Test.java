import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Lesson5Test extends BaseTest {

    @Test
    public void githubLoginTest() {
        driver.navigate().to("https://github.com");
        app.getUserHelper().loginAs("AlexSmetanin", "Printer!23");
        assertEquals(app.getUserHelper().getUsername(), "@AlexSmetanin");
    }

    @Test
    public void searchTest() {
        app.getRepositoryHelper().searchForRepo("Java");
        app.getRepositoryHelper().jumpToResults();
        app.getRepositoryHelper().selectFirstResult();
        String firstResultUrl = driver.getCurrentUrl();
        assertEquals(firstResultUrl, "https://github.com/TheAlgorithms/Java");

        driver.navigate().back();
        app.getRepositoryHelper().changeSort();
        driver.navigate().refresh();
        app.getRepositoryHelper().selectFirstResult();
        assertFalse(driver.getCurrentUrl()==firstResultUrl);
    }

}
