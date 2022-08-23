package website.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import website.pages.WebshopLandingPage;
import website.registrationpage.MissingValuesRegistrationPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Web shop")
@Feature("Web shop test")
public class MissingValuesRegistrationTest extends WebsiteTesBase {
    private static final String ERROR_MESSAGE = "You must register at least one phone number.";
    private static final String ERROR_LAST = "lastname is required.";

    @DisplayName("Registration - missing required values Test")
    @Step("Click on the Sing In menu link\n" +
            "Type newEmail in the create account email address field on the Authentication page\n" +
            "Click the Create an Account button on the Authentication page\n" +
            "Clear the email field on the Create Account page\n" +
            "Click on the Register button on the Create Account page")
    @Test
    public void missingRequiredValuesTest(){
        WebshopLandingPage webshopLandingPage = navigateToWebshopLandingPage();
        webshopLandingPage.navigateToSignInPage().navigationSignIn();

        MissingValuesRegistrationPage missingValuesRegistrationPage=new MissingValuesRegistrationPage(getDriver());
        missingValuesRegistrationPage.createAccount();

        missingValuesRegistrationPage.clearAll();

        assertTrue(missingValuesRegistrationPage.getWrongEmailErrorText().contains(ERROR_MESSAGE), "Invalid error message");
        assertTrue(missingValuesRegistrationPage.getWrongEmailErrorText().contains(ERROR_LAST), "Invalid error message");
    }
}
