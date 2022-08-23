package orangeHrm.orangehrmpage;

import mainbase.ElementEnum;
import mainbase.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class VerifyDetailsPage extends PageBase {

    @FindBy(css = "#personal_txtEmpFirstName")
    private WebElement firstname;
    @FindBy(css = "#personal_txtEmpMiddleName")
    private WebElement middlename;
    @FindBy(css =" #personal_txtEmpLastName")
    private WebElement lastname;
    @FindBy(css = "#personal_txtEmployeeId")
    private WebElement id;
    @FindBy(css = "li #personal_DOB")
    private WebElement dateOfBirth;
    @FindBy(css = "#personal_cmbMarital [selected='selected']")
    private WebElement status;
    @FindBy(css = "#personal_optGender_1")
    private WebElement gender;
    @FindBy(css = "#personal_txtLicenNo")
    private WebElement license;


    public VerifyDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void load() {

    }
    @Override
    protected void isLoaded() throws Error {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(firstname));
    }
    public WebElement gender(){
        return gender;
    }
    public String getCheckDataText(ElementEnum element){
        switch (element)
        {
            case Firstname:
                return firstname.getText();
            case Middlename:
                return  middlename.getText();
            case Lastname:
                return lastname.getText();
            case Id:
                return id.getText();
            case DateOfBirth:
                return dateOfBirth.getText();
            case Status:
                return status.getText();
            case Licens:
                return license.getText();
        }
        return null;
    }
    public String getCheckDataValue(ElementEnum element){
        switch (element)
        {
            case Firstname:
                return firstname.getAttribute("value");
            case Middlename:
                return  middlename.getAttribute("value");
            case Lastname:
                return lastname.getAttribute("value");
            case Id:
                return id.getAttribute("value");
            case DateOfBirth:
                return dateOfBirth.getAttribute("value");
            case Status:
                return status.getAttribute("value");
            case Licens:
                return license.getAttribute("value");
        }
        return null;
    }
}
