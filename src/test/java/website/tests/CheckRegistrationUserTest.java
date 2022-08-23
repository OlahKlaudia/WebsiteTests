package website.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import website.registrationpage.PersonalnformationPage;
import website.registrationpage.RegistrationPage;

@Epic("Web shop")
@Feature("Web shop test")
public class CheckRegistrationUserTest extends WebsiteTesBase {

    @DisplayName("Check Registration User Test")
    @Step("Click on the Sing In menu link\n" +
            "Fill in the fields\n" +
            "Click the Register button\n" +
            "Click the My Address button\n")
    @Test
    public void registrationTest() {
        WebsiteTesBase websiteTesBase=new WebsiteTesBase();
        websiteTesBase.navigateToWebshopLandingPage();

        RegistrationPage registrationPage=new RegistrationPage(getDriver());
        registrationPage.navigateToSignIn();

        PersonalnformationPage checkPersonalInformation= new  PersonalnformationPage(getDriver());
        checkPersonalInformation.personalInformationPage(createRandUser());
        checkPersonalInformation.clickRegisterButton();
    }
}
