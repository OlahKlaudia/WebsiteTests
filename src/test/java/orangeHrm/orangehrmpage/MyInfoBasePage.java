package orangeHrm.orangehrmpage;

import mainbase.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class MyInfoBasePage extends PageBase {
    @FindBy(css = "#menu_pim_viewMyDetails")
    private WebElement clickMyInfo;
    private static final String WAIT_LIST_LOAD = "https://opensource-demo.orangehrmlive.com/index.php/pim/viewMyDetails";

    public MyInfoBasePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        driver.getCurrentUrl().contains(WAIT_LIST_LOAD);
    }

    public void clickMyInfo() {
        wait.until(ExpectedConditions.visibilityOf(clickMyInfo));
        clickMyInfo.click();
    }
}
