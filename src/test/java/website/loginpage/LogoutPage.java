package website.loginpage;

import mainbase.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LogoutPage extends PageBase {
    @FindBy(css = ".header_user_info .logout")
    private WebElement clicksignOutButton;

    private static final String URL_SIGN_IN_PAGE = "http://automationpractice.com/index.php?controller=authentication&back=my-account";

    public LogoutPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        driver.getCurrentUrl().contains(URL_SIGN_IN_PAGE);
    }

    public void logInAndLogOut() {
        wait.until(ExpectedConditions.visibilityOf(clicksignOutButton));
        clicksignOutButton.click();
    }


}
