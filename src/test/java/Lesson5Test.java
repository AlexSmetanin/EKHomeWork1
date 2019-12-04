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
        app.getSearchHelper().searchForRepo("Java");
        app.getSearchHelper().jumpToResults();
        app.getSearchHelper().selectFirstResult();
        String firstResultUrl = driver.getCurrentUrl();
        assertEquals(firstResultUrl, "https://github.com/TheAlgorithms/Java");

        driver.navigate().back();
        app.getSearchHelper().changeSort();
        driver.navigate().refresh();
        app.getSearchHelper().selectFirstResult();
        assertFalse(driver.getCurrentUrl()==firstResultUrl);
    }

}
