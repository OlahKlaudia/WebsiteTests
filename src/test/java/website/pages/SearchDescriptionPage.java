package website.pages;

import mainbase.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchDescriptionPage extends PageBase {
    @FindBy(css = ".fancybox-iframe")
    private WebElement iframe;
    @FindBy(css = "#short_description_content p")
    private WebElement findParagraph;

    public SearchDescriptionPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(iframe));
    }

    public void checkParagraphDescription() {
        driver.switchTo().frame(iframe);
    }
    public String getFindParagraphText() {
        return findParagraph.getText();
    }
}
