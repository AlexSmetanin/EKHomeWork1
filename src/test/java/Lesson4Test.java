import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Lesson4Test extends BaseTest {

    @Test
    public void githubLoginTest() {
        driver.navigate().to("https://github.com");
        app.getUserHelper().loginAs("AlexSmetanin", "Printer!23");
        assertEquals(app.getUserHelper().getUsername(), "@AlexSmetanin");
    }

    @Test
    public void searchTest() {
        app.getUserHelper().searchForRepo("Selenium");
        app.getUserHelper().selectFirstResult();
        assertTrue(driver.getCurrentUrl().contains("q=Selenium"));
        assertEquals(driver.getCurrentUrl(), "https://github.com/search?q=Selenium");
        assertEquals(app.getUserHelper().getSearchFieldValue(), "Selenium");
    }

}
