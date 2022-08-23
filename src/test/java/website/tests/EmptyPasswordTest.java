package website.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import website.loginpage.EmptyPasswordPage;
import org.junit.jupiter.api.Test;
import website.pages.WebshopLandingPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Web shop")
@Feature("Web shop test")
public class EmptyPasswordTest extends WebsiteTesBase {
    private static final String ERROR_MESSAGE = "Password is required.";

    @DisplayName("Login empty password field error validation Test")
    @Step("Click on the Sing In menu link\n" +
            "Type email in the sign in section’s email address field on the Authentication page\n" +
            "Leave blank the password field  in the sign in section \n" +
            "Click the Sign In button on the Authentication page\n")
    @Test
    public void emptyPasswordTest() {
        WebshopLandingPage webshopLandingPage = navigateToWebshopLandingPage();
        webshopLandingPage.navigateToSignInPage().navigationSignIn();
        EmptyPasswordPage emptyPassword = new EmptyPasswordPage(getDriver());
        emptyPassword.emptyPasswordField();

        assertTrue(emptyPassword.getCheckVisibleNameText().contains(ERROR_MESSAGE), "Incorrect error message.");
    }
}
