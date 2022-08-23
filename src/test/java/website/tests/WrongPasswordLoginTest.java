package website.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import website.loginpage.WrongPasswordPage;
import org.junit.jupiter.api.Test;
import website.pages.WebshopLandingPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Web shop")
@Feature("Web shop test")
public class WrongPasswordLoginTest extends WebsiteTesBase {
    private static final String ERROR_MESSAGE = "Authentication failed.";

    @DisplayName("Login - wrong password error validation Test")
    @Step("Click on the Sing In menu link\n" +
            "Type email in the sign in section’s email address field on the Authentication page\n" +
            "Type wrongPassword in the sin in section’s password field\n" +
            "Click the Sign In button on the Authentication page\n")
    @Test
    public void wrongPassword(){
        WebshopLandingPage webshopLandingPage = navigateToWebshopLandingPage();
        webshopLandingPage.navigateToSignInPage().navigationSignIn();

        WrongPasswordPage wrongPasswordErrorPage=new WrongPasswordPage(getDriver());
        wrongPasswordErrorPage.wrongPasswordErrorValidation();

        assertTrue(wrongPasswordErrorPage.getCheckVisibleNameText().contains(ERROR_MESSAGE), "Incorrect error message.");
    }
}
