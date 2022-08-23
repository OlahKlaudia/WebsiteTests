package website.registrationpage;

import mainbase.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BirthDateRegistrationPage extends PageBase {

    @FindBy(css = "#days [value='20']")
    private WebElement dayOfBirth;
    @FindBy(css = "#months [value='7']")
    private WebElement monthOfBirth;
    @FindBy(css = "#years [value='2022']")
    private WebElement yearOfBirth;
    @FindBy(css = ".icon-user")
    private WebElement clickPersonalInformation;
    @FindBy(css = "#days [selected='selected']")
    private WebElement dayAssert;
    @FindBy(css = "#months [selected='selected']")
    private WebElement monthAssert;
    @FindBy(css = "#years [selected='selected']")
    private WebElement yearAssert;


    public BirthDateRegistrationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
    }

    public void birthDateCreationPage() {

        dayOfBirth.click();

        monthOfBirth.click();

        yearOfBirth.click();
    }
    public void checkMyBirthPage() {
        clickPersonalInformation.click();
    }
    public WebElement getDayAssert() {
        return dayAssert;
    }
    public WebElement getMonthAssert() {
        return monthAssert;
    }
    public WebElement getYearAssert() {
        return yearAssert;
    }
}
