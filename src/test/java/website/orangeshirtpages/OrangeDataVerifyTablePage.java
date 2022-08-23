package website.orangeshirtpages;

import mainbase.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrangeDataVerifyTablePage extends PageBase {
    @FindBy(css = ".cart_navigation a")
    private WebElement clickProceedToCheckoutTableButton;
    @FindBy(css = "#SubmitLogin")
    private WebElement checkSignInButtonLoad;

    public OrangeDataVerifyTablePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        checkSignInButtonLoad.isDisplayed();
    }

    public void orangeDataVerifyTable() {
        wait.until(ExpectedConditions.visibilityOf(clickProceedToCheckoutTableButton));
        clickProceedToCheckoutTableButton.click();
    }

}
