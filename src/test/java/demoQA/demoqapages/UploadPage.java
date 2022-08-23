package demoQA.demoqapages;

import mainbase.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UploadPage extends PageBase {

    @FindBy(css = "#uploadFile")
    private WebElement chooseFile;
    @FindBy(css = "#downloadButton")
    private WebElement downloadFile;
    private static final String SELECTED_FILE = ".\\Downloads\\image.png";
    public UploadPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
    }

    public void uploadFile() {
        wait.until(ExpectedConditions.visibilityOf(chooseFile));
        action.click(chooseFile).build().perform();
        action.sendKeys(SELECTED_FILE);

        wait.until(ExpectedConditions.visibilityOf(downloadFile));
        action.click(downloadFile).build().perform();
    }
}
