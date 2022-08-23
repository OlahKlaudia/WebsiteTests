package mainbase;

import mainbase.factory.DriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
@ExtendWith(ScreenshotExtension.class)
abstract public class TestBase {
    private static WebDriver driver;
    private static final String URL = "http://192.168.0.146:4444/wd/hub";
    private static final String CHOOSE_BROWSER = System.getProperty("browser");
    private static boolean BROWSER_REMOTE = Boolean.parseBoolean(System.getProperty("remote"));
    protected static final Logger logger= LoggerFactory.getLogger(TestBase.class);

    @BeforeEach
    public void beforeTest() throws MalformedURLException {
        if (CHOOSE_BROWSER == null) {
            driver = new DriverFactory().createRemoteWebDriver(BrowserEnum.EDGEHEADLESS,URL);
        } else
            driver = new DriverFactory().createDriver(convertedIntoEnumToString());

//        logger.info("Create 'Web Driver' for '{}' browser",getDriver());
//
//        if (BROWSER_REMOTE) {
//            driver = new DriverFactory().createRemoteWebDriver(convertedIntoEnumToString(), URL);
//        } else {
//            driver = new DriverFactory().createDriver(convertedIntoEnumToString());
//        }
    }

    public static BrowserEnum convertedIntoEnumToString() {
        for (BrowserEnum browsersEnum : BrowserEnum.values()) {
            if (CHOOSE_BROWSER.equalsIgnoreCase(browsersEnum.getName())) {
                return browsersEnum;
            }
        }
        return BrowserEnum.CHROME;
    }

    @AfterEach
    public void afterTest() {
        driver.close();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
