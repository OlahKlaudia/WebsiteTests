package website.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import website.loginpage.ForgotPasswordPage;
import org.junit.jupiter.api.Test;
import website.pages.WebshopLandingPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Web shop")
@Feature("Web shop test")
public class ForgotPasswordTest extends WebsiteTesBase {
    private static final String SENT_MESSAGE = "A confirmation email has been sent to your address: newemail@gmail.com";

    @DisplayName("Forgot password Test - retrieve password")
    @Step("Click on the Sing In menu link\n" +
            "Click on the Forgot password link on the Authentication page\n" +
            "Type email in the email field on the Forgot Password page\n" +
            "Click the Retrieve Password  button on the Forgot Password page")
    @Test
    public void forgotPasswordTest(){
        WebshopLandingPage webshopLandingPage=navigateToWebshopLandingPage();
        webshopLandingPage.navigateToSignInPage().navigationSignIn();
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(getDriver());
        forgotPasswordPage.forgotPassword();

        assertTrue(forgotPasswordPage.getCheckVisibleNameText().contains(SENT_MESSAGE), "Incorrect error message.");
    }
}
