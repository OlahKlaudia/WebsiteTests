package website.loginpage;

import mainbase.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
public class LoginWebsitePage extends PageBase {
    @FindBy(css = "#email")
    private WebElement createEmail;
    @FindBy(css = "#passwd")
    private WebElement createAnAccount;
    @FindBy(css = "#SubmitLogin")
    private WebElement clickSignInButton;
    @FindBy(css = ".header_user_info span")
    private WebElement checkVisibleName;
    @FindBy(css = ".header_user_info .logout")
    private WebElement clicksignOutButton;

    private static final String EMAIL_ADDRESS = "newemail@gmail.com";
    private static final String PASSWORD = "password";

    public LoginWebsitePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(createEmail));
    }

    public void loginToWebsite() {
        createEmail.sendKeys(EMAIL_ADDRESS);

        wait.until(ExpectedConditions.visibilityOf(createAnAccount));
        createAnAccount.sendKeys(PASSWORD);

        wait.until(ExpectedConditions.visibilityOf(clickSignInButton));
        clickSignInButton.click();
    }

    public WebElement getCheckVisibleNameText() {
        wait.until(ExpectedConditions.visibilityOf(checkVisibleName));
        return checkVisibleName;
    }
    public WebElement getCheckLogoutButton() {
        return clicksignOutButton;
    }
}
