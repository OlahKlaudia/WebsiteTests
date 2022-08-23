package website.registrationpage;

import mainbase.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import website.pages.User;

public class PersonalnformationPage extends PageBase {
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

    @FindBy(css = "#days [value='20']")
    private WebElement dayOfBirth;

    @FindBy(css = "#months [value='7']")
    private WebElement monthOfBirth;
    @FindBy(css = "#years [value='2022']")
    private WebElement yearOfBirth;
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
    @FindBy(css = ".account span")
    private WebElement visibleUserName;
    private static final String URL_SIGN_IN_PAGE = "http://automationpractice.com/index.php?controller=authentication&back=my-account";

    public PersonalnformationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        driver.getCurrentUrl().contains(URL_SIGN_IN_PAGE);
    }

    public void personalInformationPage(User user) {
        firstname.sendKeys(user.getFirstName());
        lastname.sendKeys(user.getLastName());
        email.sendKeys(user.getEmail());
        password.sendKeys(user.getPassword());
        addressFirstName.sendKeys(user.getFirstName());
        addressLastName.sendKeys(user.getLastName());
        address.sendKeys(user.getAddress());
        city.sendKeys(user.getState());
        zip.sendKeys(user.getZip());
        state.click();
        phoneMobile.sendKeys(user.getPhone());
        aliasAddress.sendKeys(user.getAlias_address());
    }
    public void clickRegisterButton(){
        wait.until(ExpectedConditions.visibilityOf(clickRegisterButton));
        clickRegisterButton.click();
    }
    public WebElement getUsernameText() {
        return visibleUserName;
    }
}
