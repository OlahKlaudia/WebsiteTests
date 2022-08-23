package website.loginpage;

import mainbase.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EmptyPasswordPage extends PageBase {
    @FindBy(css = "#email")
    private WebElement createEmail;
    @FindBy(css = "#SubmitLogin")
    private WebElement clickSignInButton;
    @FindBy(css = ".alert ol li")
    private WebElement checkVisibleName;

    private static final String EMAIL_ADDRESS = "newemail@gmail.com";

    public EmptyPasswordPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {

    }

    public void emptyPasswordField() {
        wait.until(ExpectedConditions.visibilityOf(createEmail));
        createEmail.sendKeys(EMAIL_ADDRESS);

        wait.until(ExpectedConditions.visibilityOf(clickSignInButton));
        clickSignInButton.click();
    }
    public String getCheckVisibleNameText(){
        wait.until(ExpectedConditions.visibilityOf(checkVisibleName));
        return checkVisibleName.getText();
    }
}
