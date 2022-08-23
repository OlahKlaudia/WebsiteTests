package demoQA.demoqapages;

import mainbase.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
public class WidgetPage extends PageBase {
    @FindBy(css = "#toolTipButton")
    private WebElement hoverButton;
    @FindBy(css = "#buttonToolTip")
    private WebElement hoverButtonText;
    @FindBy(css = "#toolTipTextField")
    private WebElement textField;
    @FindBy(css = "#textFieldToolTip")
    private WebElement hovertextField;


    public WidgetPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
    }

    public void checkHoverTexts() {
        wait.until(ExpectedConditions.visibilityOf(hoverButton));
        action.moveToElement(hoverButton).build().perform();
        action.click(hoverButton).build().perform();

        wait.until(ExpectedConditions.visibilityOf(textField));
        action.moveToElement(textField).build().perform();
        action.click(textField).build().perform();
    }
    public String getHoverButtonText(){
        wait.until(ExpectedConditions.visibilityOf(hoverButtonText));
        return hoverButtonText.getText();
    }
    public String getHovertextField(){
        wait.until(ExpectedConditions.visibilityOf(hovertextField));
        return hovertextField.getText();
    }
}
