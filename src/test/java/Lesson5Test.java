import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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
        assertEquals(driver.getCurrentUrl(), "https://github.com/TheAlgorithms/Java");
        driver.navigate().back();

    }

}
