package website.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import website.pages.WebshopLandingPage;
import website.registrationpage.UsedEmailErrorPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Web shop")
@Feature("Web shop test")
public class UsedEmailRegistrationTest extends WebsiteTesBase {
    private static final String ERROR_MESSAGE = "An account using this email address has already been registered. Please enter a valid password or request a new one.";

    @DisplayName("Registration - used email error validation Test")
    @Step("Click on the Sing In menu link\n" +
            "Type usedEmail in the create account email address field on the Authentication page\n" +
            "Click the Create an Account button on the Authentication page\n")
    @Test
    public void usedEmailValidError(){
        WebshopLandingPage webshopLandingPage = navigateToWebshopLandingPage();
        webshopLandingPage.navigateToSignInPage().navigationSignIn();

        UsedEmailErrorPage usedEmailErrorPage=new UsedEmailErrorPage(getDriver());
        usedEmailErrorPage.usedEmail();

        assertTrue(usedEmailErrorPage.getWrongEmailErrorText().contains(ERROR_MESSAGE), "Incorrect error message.");
    }
}
