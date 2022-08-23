package website.registrationpage;

import mainbase.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class MissingValuesRegistrationPage extends PageBase {
    @FindBy(css = "#customer_firstname")
    private WebElement firstname;
    @FindBy(css = "#customer_lastname")
    private WebElement lastname;
    @FindBy(css = "#email")
    private WebElement email;
    @FindBy(css = "#passwd")
    private WebElement password;
    @FindBy(css = "#firstname")
    private WebElement addressFirstName;
    @FindBy(css = "#lastname")
    private WebElement addressLastName;
    @FindBy(css = "#address1")
    private WebElement address;
    @FindBy(css = "#city")
    private WebElement city;
    @FindBy(css = "#postcode")
    private WebElement zip;
    @FindBy(css = "#id_state [value='46']")
    private WebElement state;
    @FindBy(css = "#phone_mobile")
    private WebElement phoneMobile;
    @FindBy(css = "#alias")
    private WebElement aliasAddress;
    @FindBy(css = "#submitAccount")
    private WebElement clickRegisterButton;
    @FindBy(css = "#center_column ol")
    private WebElement wrongEmailError;
    @FindBy(css = ".form-group  input")
    private WebElement createEmail;
    @FindBy(css = "#SubmitCreate")
    private WebElement createAnAccount;

    private static final Random RANDOM_NUMBER = new Random();
    private static final String EMAIL_ADDRESS = "newemail" + RANDOM_NUMBER.nextInt() + "@gmail.com";

    public MissingValuesRegistrationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(createAnAccount));
    }

    public void createAccount() {
        createEmail.sendKeys(EMAIL_ADDRESS);
        createAnAccount.click();
    }

    public void clearAll() {
        wait.until(ExpectedConditions.visibilityOf(firstname));
        firstname.clear();
        lastname.clear();
        email.clear();
        password.clear();
        addressFirstName.clear();
        addressLastName.clear();
        address.clear();
        city.clear();
        zip.clear();
        phoneMobile.clear();
        aliasAddress.clear();

        wait.until(ExpectedConditions.visibilityOf(clickRegisterButton));
        clickRegisterButton.click();
    }

    public String getWrongEmailErrorText() {
        return wrongEmailError.getText();
    }

}
