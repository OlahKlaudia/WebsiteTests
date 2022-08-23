package website.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import website.registrationpage.BirthDateRegistrationPage;
import website.registrationpage.PersonalnformationPage;
import website.registrationpage.RegistrationPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Web shop")
@Feature("Web shop test")
public class RegistrationBirthTest extends WebsiteTesBase {

    @DisplayName("Registration - set the birth date on creation  Test")
    @Step("Click on the Sing In menu link\n" +
            "Type newEmail in the create account email address field on the Authentication page\n" +
            "Click the Create an Account button on the Authentication page\n"+
            "Click the Register button"+
            "Click on the Details button in the My Account page\n")
    @Test
    public void registrationBirthTest() {
        WebsiteTesBase websiteTesBase=new WebsiteTesBase();
        websiteTesBase.navigateToWebshopLandingPage();

        RegistrationPage registrationPage = new RegistrationPage(getDriver());
        registrationPage.navigateToSignIn();

        PersonalnformationPage checkPersonalInformation = new PersonalnformationPage(getDriver());
        checkPersonalInformation.personalInformationPage(createRandUser());

        BirthDateRegistrationPage bPage = new BirthDateRegistrationPage(getDriver());
        bPage.birthDateCreationPage();

        checkPersonalInformation.clickRegisterButton();
        bPage.checkMyBirthPage();

        assertTrue(bPage.getDayAssert().isDisplayed(), "Incorrect data.");
        assertTrue(bPage.getMonthAssert().isDisplayed(), "Incorrect data.");
        assertTrue(bPage.getYearAssert().isDisplayed(), "Incorrect data.");
    }
}
