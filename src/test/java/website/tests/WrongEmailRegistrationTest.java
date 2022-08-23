package website.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import website.pages.WebshopLandingPage;
import website.registrationpage.InvalidEmailPage;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Web shop")
@Feature("Web shop test")
public class WrongEmailRegistrationTest extends WebsiteTesBase {
    private static final String INVALID_EMAIL = "Invalid email address";

    @DisplayName("Registration - wrong email format error validations Test")
    @Step("Click on the Sign in menu link\n" +
            "Type wrongEmail(n) in the create account email address field on the Authentication page\n" +
            "Click the Create an Account button on the Authentication page\n" +
            "Click `Proceed to checkout`\n" +
            "Check the the sign in page is loaded\n")
    @Test
    public void wrongEmailRegistration() {
        WebshopLandingPage webshopLandingPage = navigateToWebshopLandingPage();
        webshopLandingPage.navigateToSignInPage().navigationSignIn();

        InvalidEmailPage invalidEmailPage = new InvalidEmailPage(getDriver());
        invalidEmailPage.invalidEmail();

        assertTrue(invalidEmailPage.getEmailAddressInput().isDisplayed(), "not found email address input.");
    }
}
