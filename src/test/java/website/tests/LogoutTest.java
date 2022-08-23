package website.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import website.loginpage.LoginWebsitePage;
import website.loginpage.LogoutPage;
import org.junit.jupiter.api.Test;
import website.pages.WebshopLandingPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Web shop")
@Feature("Web shop test")
public class LogoutTest extends WebsiteTesBase {

    @DisplayName("Login - logout Test")
    @Step("Click on the Sing In menu link\n" +
            "Type email in the sign in section’s email address field on the Authentication page\n" +
            "Type password in the Password field\n" +
            "Click the Sign In button\n" +
            "Click on the Logout button in the menu on the Account page\n")
    @Test
    public void logoutTest(){
        WebshopLandingPage webshopLandingPage = navigateToWebshopLandingPage();
        webshopLandingPage.navigateToSignInPage().navigationSignIn();

        LoginWebsitePage login = new LoginWebsitePage(getDriver());
        login.loginToWebsite();
        assertTrue(login.getCheckLogoutButton().isDisplayed(), "Not found Logout button");

        LogoutPage logout=new LogoutPage(getDriver());
        logout.logInAndLogOut();


    }
}
