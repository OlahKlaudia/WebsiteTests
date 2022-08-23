package website.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import website.loginpage.LoginWebsitePage;
import org.junit.jupiter.api.Test;
import website.pages.WebshopLandingPage;
import website.registrationpage.NavigateToSignInPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Web shop")
@Feature("Web shop test")
public class LoginTest extends WebsiteTesBase {

    @DisplayName("Login Test")
    @Step("Click on the Sing In menu link\n" +
            "Type email in the sign in section’s email address field on the Authentication page\n" +
            "Type password in the Password field\n" +
            "Click the Sign In button\n")
    @Test
    public void loginTest() {
        WebshopLandingPage webshopLandingPage = navigateToWebshopLandingPage();
        webshopLandingPage.navigateToSignInPage().navigationSignIn();

        NavigateToSignInPage navigateToSignInPage = new NavigateToSignInPage(getDriver());
        navigateToSignInPage.navigationSignIn();
        LoginWebsitePage loginWebsitePage = new LoginWebsitePage(getDriver());
        loginWebsitePage.loginToWebsite();

        assertTrue(loginWebsitePage.getCheckVisibleNameText().isDisplayed(), "Incorrect error message.");
    }
}
