package orangeHrm.orangehrmpage;

import mainbase.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends PageBase {
    @FindBy(css = "#txtUsername")
    private WebElement username;
    @FindBy(css = "#txtPassword")
    private WebElement passwd;
    @FindBy(css = ".button")
    private WebElement clickLogin;
    private static final String USERNAME = "Admin ";
    private static final String PASSWORD = "admin123";

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @Override
    protected void isLoaded() throws Error {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(clickLogin));
    }
    public void loginWebsite() {
        username.sendKeys(USERNAME);
        passwd.sendKeys(PASSWORD);
        clickLogin.click();
    }
}
