package website.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import website.loginpage.UnregisteredPasswordPage;
import org.junit.jupiter.api.Test;
import website.pages.WebshopLandingPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Web shop")
@Feature("Web shop test")
public class UnregisteredEmailTest extends WebsiteTesBase {
    private static final String ERROR_MESSAGE = "Authentication failed.";

    @DisplayName("Login - unregistered email error validation Test")
    @Step("Click on the Sing In menu link\n" +
            "Type a unique unregistered email in the sign in section’s email address field on the Authentication page\n" +
            "Type a password into password field \n" +
            "Click the Sign In button on the Authentication page")
    @Test
    public void unregisteredEmailTest(){
        WebshopLandingPage webshopLandingPage = navigateToWebshopLandingPage();
        webshopLandingPage.navigateToSignInPage().navigationSignIn();

        UnregisteredPasswordPage wrongEmailPage=new UnregisteredPasswordPage(getDriver());
        wrongEmailPage.uniqueEmail();

        assertTrue(wrongEmailPage.getWrongEmailErrorText().contains(ERROR_MESSAGE), "Incorrect error message.");
    }
}
