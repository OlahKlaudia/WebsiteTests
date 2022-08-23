package website.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import website.registrationpage.PersonalnformationPage;
import website.registrationpage.RegistrationPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Web shop")
@Feature("Web shop test")
public class RegistrationTest extends WebsiteTesBase {

    @DisplayName("Registration Test")
    @Step("Click on the Sing In menu link\n" +
            "Type a new email in the create account email address field on the Authentication page\n" +
            "Click on the Create an Account button on the Authentication page\n"+
            "Click the Register button")
    @Test
    public void registrationTest() {
        WebsiteTesBase websiteTesBase=new WebsiteTesBase();
        websiteTesBase.navigateToWebshopLandingPage();

        RegistrationPage registration = new RegistrationPage(getDriver());
        registration.navigateToSignIn();

        PersonalnformationPage checkPersonalInformation = new PersonalnformationPage(getDriver());
        checkPersonalInformation.personalInformationPage(createRandUser());
        checkPersonalInformation.clickRegisterButton();

        assertTrue(checkPersonalInformation.getUsernameText().isDisplayed(), "Not found Username.");
    }
}
