package mainbase.factory;

import mainbase.BrowserEnum;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public interface DriverInterface {
    WebDriver createDriver();
    WebDriver createRemoteDriver(BrowserEnum browser, String url) throws MalformedURLException;
}
