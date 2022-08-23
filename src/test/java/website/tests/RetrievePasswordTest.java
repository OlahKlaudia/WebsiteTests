package website.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import website.loginpage.RetrievePasswordPage;
import org.junit.jupiter.api.Test;
import website.pages.WebshopLandingPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Web shop")
@Feature("Web shop test")
public class RetrievePasswordTest extends WebsiteTesBase {
    private static final String SENT_MESSAGE = "There is no account registered for this email address.";

    @DisplayName("Forgot password  - retrieve password Test")
    @Step("Click on the Sing In menu link\n" +
            "Click on the Forgot password link on the Authentication page\n" +
            "Type email in the email field on the Forgot Password page\n" +
            "Click the Retrieve Password  button on the Forgot Password page\n")
    @Test
    public void retrievePasswordTest(){
        WebshopLandingPage webshopLandingPage = navigateToWebshopLandingPage();
        webshopLandingPage.navigateToSignInPage().navigationSignIn();

        RetrievePasswordPage retrievePassword= new RetrievePasswordPage(getDriver());
        retrievePassword.retrievePassword();

        assertTrue(retrievePassword.getCheckVisibleNameText().contains(SENT_MESSAGE), "Incorrect error message.");
    }
}
