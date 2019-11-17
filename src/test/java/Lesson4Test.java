import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Lesson4Test extends BaseTest {

    @Test
    public void githubLoginTest() {
        driver.navigate().to("https://github.com");
        app.getUserHelper().loginAs("AlexSmetanin", "Printer!23");
        assertEquals(app.getUserHelper().getUsername(), "@AlexSmetanin");
    }
}
