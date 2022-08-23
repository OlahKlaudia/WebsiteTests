package website.loginpage;

import mainbase.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ForgotPasswordPage extends PageBase {
    @FindBy(css = ".lost_password a")
    private WebElement clickForgotPassword;
    @FindBy(css = "#email")
    private WebElement createEmail;
    @FindBy(css = ".submit button")
    private WebElement clickRetrievePassword;
    @FindBy(css = ".box p")
    private WebElement checkVisibleName;

    private static final String EMAIL_ADDRESS = "newemail@gmail.com";

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(clickForgotPassword));
    }

    public void forgotPassword() {
        clickForgotPassword.click();

        wait.until(ExpectedConditions.visibilityOf(createEmail));
        createEmail.sendKeys(EMAIL_ADDRESS);

        wait.until(ExpectedConditions.visibilityOf(clickRetrievePassword));
        clickRetrievePassword.click();
    }
    public String getCheckVisibleNameText(){
        wait.until(ExpectedConditions.visibilityOf(checkVisibleName));
        return checkVisibleName.getText();
    }
}
