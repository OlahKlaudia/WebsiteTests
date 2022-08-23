package website.orangeshirtpages;

import mainbase.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OrangeDataVerifyPage extends PageBase {
    @FindBy(css = "#layer_cart .icon-chevron-right")
    private WebElement clickProceedTheCheckoutButton;
    @FindBy(css = "#layer_cart .icon-chevron-right")
    private WebElement waiting;


    public OrangeDataVerifyPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
      waiting.isDisplayed();
    }

    public void orangeDataVerify() {
        wait.until(ExpectedConditions.visibilityOf(clickProceedTheCheckoutButton));
        clickProceedTheCheckoutButton.click();
    }

}
