package website.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import website.loginpage.WrongLoginPage;
import org.junit.jupiter.api.Test;
import website.pages.WebshopLandingPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Web shop")
@Feature("Web shop test")
public class WrongEmailLoginTest extends WebsiteTesBase {
    private static final String ERROR_MESSAGE = "Invalid email address.";

    @DisplayName("Login - wrong email format error validations Test")
    @Step("Click on the Sing In menu link\n" +
            "Type wrongEmail(n) in the sign in section’s email address field on the Authentication page\n" +
            "Click the Sign In button on the Authentication page\n")
    @Test
    public void wrongEmailFormatLoginTest() {
        WebshopLandingPage webshopLandingPage = navigateToWebshopLandingPage();
        webshopLandingPage.navigateToSignInPage().navigationSignIn();

        WrongLoginPage wrongLoginError = new WrongLoginPage(getDriver());
        wrongLoginError.wrongLoginWithWrongEmail();

        assertTrue(wrongLoginError.getEmailErrorText().contains(ERROR_MESSAGE), "Incorrect error message.");
    }
}
