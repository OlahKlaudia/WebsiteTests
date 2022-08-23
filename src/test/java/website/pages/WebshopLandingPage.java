package website.pages;

import mainbase.PageBase;
import org.openqa.selenium.WebDriver;
import website.registrationpage.NavigateToSignInPage;

public class WebshopLandingPage extends PageBase {
    private static final String WEBSITE_URL = "http://automationpractice.com";

    public WebshopLandingPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void isLoaded() throws Error {
        driver.getCurrentUrl().contains(WEBSITE_URL);
    }
    public NavigateToSignInPage navigateToSignInPage(){
        return new NavigateToSignInPage(driver);
    }

    //navigation
}
