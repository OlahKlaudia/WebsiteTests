package website.pages;

import mainbase.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class VerifyTableDataPage extends PageBase {
    @FindBy(css = "#SubmitLogin")
    private WebElement checkSignInButtonLoad;
    @FindBy(css = ".cart_navigation a")
    private WebElement clickProceedToCheckoutTableButton;

    public VerifyTableDataPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        checkSignInButtonLoad.isDisplayed();
    }

    public void verifyTableData() {
        wait.until(ExpectedConditions.visibilityOf(clickProceedToCheckoutTableButton));
        clickProceedToCheckoutTableButton.click();
    }
}
