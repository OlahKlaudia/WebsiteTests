package demoQA.demoqapages;

import mainbase.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicPropertyPage extends PageBase {

    @FindBy(css = "div p")
    private WebElement checkParagraph;

    @FindBy(css = "#colorChange")
    private WebElement checkButtonIsVisible;
    @FindBy(css = ".header-wrapper")
    private WebElement elementitem;
    public DynamicPropertyPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void load() {
    }

    @Override
    protected void isLoaded() throws Error {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(checkParagraph));
    }
    public String checkParagraphName() {

        return checkParagraph.getText();

    }
    public WebElement checkButtonIsVisible(){
        return checkButtonIsVisible;
    }

    public String getColor() {
        wait.until(ExpectedConditions.visibilityOf(checkButtonIsVisible));
        return checkButtonIsVisible.getCssValue("color");
    }

    public String fromStringToRgba() {
        return Color.fromString(getColor()).asRgba();
    }

}
