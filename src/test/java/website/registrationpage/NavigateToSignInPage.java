package website.registrationpage;

import mainbase.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NavigateToSignInPage extends PageBase {
    @FindBy(css = ".header_user_info a")
    private WebElement clickSignIn;

    private static final String URL_SIGN_IN_PAGE = "http://automationpractice.com/index.php?controller=authentication&back=my-account";

    public NavigateToSignInPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
       driver.getCurrentUrl().contains(URL_SIGN_IN_PAGE);
    }

    public void navigationSignIn() {
        wait.until(ExpectedConditions.visibilityOf(clickSignIn));
        clickSignIn.click();
    }
}
