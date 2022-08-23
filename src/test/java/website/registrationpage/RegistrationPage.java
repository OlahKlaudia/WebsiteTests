package website.registrationpage;

import mainbase.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.Random;

public class RegistrationPage extends PageBase {
    @FindBy(css = ".header_user_info a")
    private WebElement clickSignIn;
    @FindBy(css = ".form-group  input")
    private WebElement emailAddressInput;
    @FindBy(css = "#SubmitCreate")
    private WebElement clickCreateAnAccountButton;
    private static final Random RANDOM_NUMBER = new Random();
    private static final String EMAIL_ADDRESS = "newemail" + RANDOM_NUMBER.nextInt() + "@gmail.com";
    private static final String URL_SIGN_IN_PAGE = "http://automationpractice.com/index.php?controller=authentication&back=my-account";

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        driver.getCurrentUrl().contains(URL_SIGN_IN_PAGE);
    }

    public void navigateToSignIn() {
        wait.until(ExpectedConditions.visibilityOf(clickSignIn));
        clickSignIn.click();
        emailAddressInput.sendKeys(EMAIL_ADDRESS);
        clickCreateAnAccountButton.click();
    }
}
