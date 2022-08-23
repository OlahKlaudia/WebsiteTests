package orangeHrm.orangehrmpage;

import mainbase.CreateScreenshot;
import mainbase.PageBase;
import org.openqa.selenium.WebDriver;

public class NavigateOrangeHrmBasePage extends PageBase {
    private static final String WAIT_LIST_LOAD = "https://opensource-demo.orangehrmlive.com/";
    public NavigateOrangeHrmBasePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void load() {

    }
    @Override
    protected void isLoaded() throws Error {
        driver.getCurrentUrl().contains(WAIT_LIST_LOAD);
    }

    public void createScreenshot() {
        new CreateScreenshot().createScreenshot(driver);
    }
}
