package website.registrationpage;

import mainbase.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UsedEmailErrorPage extends PageBase {
    @FindBy(css = ".form-group input")
    private WebElement wrongEmail;
    @FindBy(css = "#SubmitCreate")
    private WebElement createAnAccount;
    @FindBy(css = "#create_account_error ol li")
    private WebElement wrongEmailError;
    private static final String USED_EMAIL = "newemail@gmail.com";

    public UsedEmailErrorPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        createAnAccount.isDisplayed();
    }
    public void usedEmail(){
        wait.until(ExpectedConditions.visibilityOf(wrongEmail));
        wrongEmail.sendKeys(USED_EMAIL);
        createAnAccount.click();
    }
    public String getWrongEmailErrorText() {
        return wrongEmailError.getText();
    }
}
