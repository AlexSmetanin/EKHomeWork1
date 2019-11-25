package webdriver;

import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class WebDriverFactory {

    private static final String CHROME = "chrome";

    private WebDriver webDriver = null;

    public WebDriver getInstance(String browser) throws Exception {
        if (CHROME.equals(browser)) {
            boolean isLocal = System.getProperty("headless").equalsIgnoreCase("true");
            File chromeDriver = new File(System.getProperty("chrome.driver.path"));
            ChromeDriverService service = new ChromeDriverService.Builder()
                    .usingDriverExecutable(chromeDriver)
                    .withEnvironment(ImmutableMap.of("DISPLAY", ":20"))
                    .usingAnyFreePort()
                    .build();
            ChromeOptions options = new ChromeOptions();
            Map<String, Object> prefs = new HashMap<>();
            prefs.put("profile.default_content_setting_values.notifications", 2);
            prefs.put("intl.accept_languages", "en-US");
            options.setExperimentalOption("prefs", prefs);
            options.addArguments("--disable-plugins");
            options.addArguments("disable-infobars");
            options.addArguments("'--disable-site-isolation-trials'");
            options.addArguments("--windows-size=1920,1080");
            if (!isLocal) {
                options.addArguments("srart-maximized");
                options.addArguments("eneble-automation");
                options.addArguments("--headless");
                options.addArguments("--no-sanbox");
                options.addArguments("--disable-browser-side-navigation");
                options.addArguments("--disable-gpu");
                options.addArguments("--use-fake-ui-fot-media-stream");
            }
            webDriver = new ChromeDriver(service, options);

        }
        return webDriver;
    }
}