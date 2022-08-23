package orangeHrm.orangehrmtests;
import mainbase.TestBase;
import orangeHrm.orangehrmpage.LoginPage;

public class OrangeHrmTestBase extends TestBase {
    public static final String URL_IN_PAGE = "https://opensource-demo.orangehrmlive.com/";

    public LoginPage navigateToLoginPage() {
        getDriver().get(URL_IN_PAGE);
        return new LoginPage(getDriver());
    }
}
