package orangeHrm.orangehrmtests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import mainbase.ElementEnum;
import orangeHrm.orangehrmpage.LoginPage;
import orangeHrm.orangehrmpage.MyInfoBasePage;
import orangeHrm.orangehrmpage.VerifyDetailsPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("OrangeHrm")
@Feature("OrangeHrm test")
public class MyInfoTest extends OrangeHrmTestBase {

    @DisplayName("My info Test")
    @Step("Login with next credentials:\n" +
            "Username: `Admin`\n" +
            "Password: `admin123`\n" +
            "Navigate to `My info` page\n" +
            "Verify the Personal Details.")
    @Test
    public void myInfoTest(){
        LoginPage loginPage= navigateToLoginPage();
        loginPage.loginWebsite();

        MyInfoBasePage myInfo= new MyInfoBasePage(getDriver());
        myInfo.clickMyInfo();

        VerifyDetailsPage verifyDetails=new VerifyDetailsPage(getDriver());


        assertEquals(verifyDetails.getCheckDataText(ElementEnum.Firstname),(verifyDetails.getCheckDataValue(ElementEnum.Firstname)) );
        assertEquals(verifyDetails.getCheckDataText(ElementEnum.Middlename),(verifyDetails.getCheckDataValue(ElementEnum.Middlename)));
        assertEquals(verifyDetails.getCheckDataText(ElementEnum.Lastname),(verifyDetails.getCheckDataValue(ElementEnum.Lastname)));
        assertEquals(verifyDetails.getCheckDataText(ElementEnum.Id),(verifyDetails.getCheckDataValue(ElementEnum.Id)));
        assertEquals(verifyDetails.getCheckDataText(ElementEnum.DateOfBirth),(verifyDetails.getCheckDataValue(ElementEnum.DateOfBirth)));
        assertEquals(verifyDetails.getCheckDataText(ElementEnum.Status),(verifyDetails.getCheckDataValue(ElementEnum.Status)));
        assertEquals(verifyDetails.gender().isSelected(), "error message");
        assertEquals(verifyDetails.getCheckDataText(ElementEnum.Licens),(verifyDetails.getCheckDataValue(ElementEnum.Licens)));
    }
}
