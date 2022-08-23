package orangeHrm.orangehrmtests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import orangeHrm.orangehrmpage.LoginPage;
import orangeHrm.orangehrmpage.NavigateOrangeHrmBasePage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
@Epic("OrangeHrm")
@Feature("OrangeHrm test")
public class EmployeeClaimsTest extends OrangeHrmTestBase {

    @DisplayName(" Employee claims Test")
    @Step("Login with next credentials:\n" +
            "Username: `Admin `\n" +
            "Password: `admin123`\n" +
            "Wait for the list to load\n" +
            "Print all the even usernames from the table\n")
    @Test
    public void emloyeeClaimsTest() {
        LoginPage loginPage=navigateToLoginPage();
        loginPage.loginWebsite();

        NavigateOrangeHrmBasePage navigateOrangeHrm = new NavigateOrangeHrmBasePage(getDriver());
        navigateOrangeHrm.createScreenshot();
    }
}
