package website.registrationpage;

import mainbase.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InvalidEmailPage extends PageBase {
    @FindBy(css = ".form-group  input")
    private WebElement wrongEmail;
    @FindBy(css = "#SubmitCreate")
    private WebElement createAnAccount;
    @FindBy(css = "#create_account_error")
    private WebElement wrongEmailError;
    @FindBy(css = ".header_user_info a")
    private WebElement emailAddressInput;

    private static final String WRONG_EMAIL = "newemail";

    public InvalidEmailPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(wrongEmail));
    }
    public void invalidEmail() {
        wrongEmail.sendKeys(WRONG_EMAIL);
        createAnAccount.click();
        wait.until(ExpectedConditions.visibilityOf(emailAddressInput));
    }
    public WebElement getEmailAddressInput() {
        return emailAddressInput;
    }
}
