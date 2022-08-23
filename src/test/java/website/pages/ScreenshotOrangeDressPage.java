package website.pages;

import mainbase.CreateScreenshot;
import mainbase.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ScreenshotOrangeDressPage extends PageBase {
    @FindBy(css = "img[alt='Printed Dress']")
    private WebElement findTheOrangeDressGirl;
    public ScreenshotOrangeDressPage(WebDriver driver) {
        super(driver);
    }
    public void createScreenshotOrangeDress(){
        wait.until(ExpectedConditions.visibilityOf(findTheOrangeDressGirl));
        findTheOrangeDressGirl.click();
        new CreateScreenshot().createScreenshot(driver);
    }
}
