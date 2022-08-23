package website.tests;

import mainbase.TestBase;
import website.pages.User;
import website.pages.WebshopLandingPage;

public class WebsiteTesBase extends TestBase {
    final static String BASE_URL = "http://automationpractice.com";

    public WebshopLandingPage navigateToWebshopLandingPage() {
        getDriver().get(BASE_URL);
        return new WebshopLandingPage(getDriver());
    }

    protected User createRandUser() {
            return new User.UserBuilder("lastName")
                    .firstName("firstname")
                    .zip("25252")
                    .phone("062555555")
                    .address("Fake address 1234")
                    .email("newEmail")
                    .password("password")
                    .state("city")
                    .alias_address("aliasAddress")
                    .build();
    }
}
