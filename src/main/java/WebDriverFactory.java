import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

public class WebDriverFactory {

    private static final String CHROME = "chrome";

    private WebDriver webDriver = null;

    public WebDriver getInstance(String browser) throws Exception {
        if (CHROME.equals(browser)) {
            boolean isLocal = System.getProperty("headless").equalsIgnoreCase("true");  // PropertyLoader.loadProperties("headless").equalsIgnoreCase("true");
            File chromeDriver = new File(System.getProperty("chrome.driver.path"));                 //new File(PropertyLoader.loadProperties("chrome.driver.path"))
            ChromeDriverService service = new ChromeDriverService.Builder()
                    .usingDriverExecutable(chromeDriver)
                    .withEnvironment(ImmutableMap.of("DISPLAY", ":20"))
                    .usingAnyFreePort()
                    .build();
            ChromeOptions options = new ChromeOptions();
            LoggingPreferences logs = new LoggingPreferences();
            logs.enable(LogType.BROWSER, Level.ALL);
            logs.enable(LogType.DRIVER, Level.ALL);
            logs.enable(LogType.PERFORMANCE, Level.ALL);
            Map<String, Object> prefs = new HashMap<>();
            prefs.put("profile.default_content_setting_values.notifications", 2);
            prefs.put("intl.accept_languages", "en-US");
            options.setCapability(CapabilityType.LOGGING_PREFS, logs);
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