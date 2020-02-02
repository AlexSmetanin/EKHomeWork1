import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utility.CustomTestListener;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Listeners({CustomTestListener.class})

public class TwitterTest extends BaseTest {

    @Description("")
    @Test
    public void twitterTest() {
        app.getRepositoryHelper().goToTwitterPage();
        assertTrue(driver.getCurrentUrl().contains("https://twitter.com/github"));
        assertEquals(app.getRepositoryHelper().checkTwitterPageName(), "GitHub");
        assertTrue((app.getRepositoryHelper().checkVerifiedIconDisplayed()));
    }
}
