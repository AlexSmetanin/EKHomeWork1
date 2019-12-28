import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Lesson5Test extends BaseTest {

    @Test
    public void searchTest() {

        app.getSearchHelper().searchForRepo("Java");

        // Call method to stars count for each repository
        assertTrue(app.getSearchHelper().countStars() > 0);

        // Call method to repositories count for any language
        assertTrue(app.getSearchHelper().countLanguages("JavaScript") > 0);

        // Select first result, store current URL to variable and check if it equals to reference URL
        app.getSearchHelper().selectFirstResult();
        String firstResultUrl = driver.getCurrentUrl();
        assertEquals(firstResultUrl, "https://github.com/TheAlgorithms/Java");

       // Back to previous page, change sort type, select first result and check if it not equals to previous URL
        driver.navigate().back();
        app.getSearchHelper().changeSort();
        driver.navigate().refresh();
        app.getSearchHelper().selectFirstResult();
        assertFalse(driver.getCurrentUrl().equals(firstResultUrl));
    }

}
