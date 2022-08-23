package demoQA.demoqapages;

import mainbase.PageBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DemoQaNavigationPage extends PageBase {
    @FindBy(css = ".card:nth-child(1)")
    private WebElement navigateElements;
    @FindBy(css = ".card:nth-child(4)")
    private WebElement navigateWidget;
    @FindBy(css = ".card:nth-child(5)")
    private WebElement interaction;
    @FindBy(css = ".show #item-8")
    private WebElement moveToItemProperties;

    @FindBy(css = ".show #item-7")
    private WebElement moveToItemUpload;
    @FindBy(css = ".show #item-7 span")
    private WebElement clickUploadAndDownload;

    @FindBy(css = ".show #item-8 span")
    private WebElement clickDynamicProperties;
    @FindBy(css = ".show #item-3")
    private WebElement moveToElement;
    @FindBy(css = ".show #item-3 span")
    private WebElement clickDroppableElement;
    @FindBy(css = ".show #item-6")
    private WebElement moveToItem;
    @FindBy(css = ".show #item-6 span")
    private WebElement clickTooltips;
    @FindBy(css = ".accordion")
    private WebElement listmenu;
    public DemoQaNavigationPage(WebDriver driver) {
        super(driver);
    }
    public void navigateToElements(){
        wait.until(ExpectedConditions.visibilityOf(navigateElements));
        navigateElements.click();

        wait.until(ExpectedConditions.visibilityOf(listmenu));
        action.sendKeys(Keys.PAGE_DOWN).build().perform();

        wait.until(ExpectedConditions.visibilityOf(moveToItemProperties));
        action.moveToElement(moveToItemProperties);

        wait.until(ExpectedConditions.visibilityOf(clickDynamicProperties));
        action.click(clickDynamicProperties).build().perform();
    }
    public void navigateToElementUpload(){
        wait.until(ExpectedConditions.visibilityOf(navigateElements));
        navigateElements.click();

        wait.until(ExpectedConditions.visibilityOf(listmenu));
        action.sendKeys(Keys.PAGE_DOWN).build().perform();

        wait.until(ExpectedConditions.visibilityOf(moveToItemUpload));
        action.moveToElement(moveToItemUpload);

        wait.until(ExpectedConditions.visibilityOf(clickUploadAndDownload));
        action.click(clickUploadAndDownload).build().perform();
    }
    public void navigateToInteraction(){
        wait.until(ExpectedConditions.visibilityOf(interaction));
        interaction.click();

        wait.until(ExpectedConditions.visibilityOf(listmenu));
        action.sendKeys(Keys.PAGE_DOWN).build().perform();

        wait.until(ExpectedConditions.visibilityOf(moveToElement));
        action.moveToElement(moveToElement);

        wait.until(ExpectedConditions.visibilityOf(clickDroppableElement));
        action.click(clickDroppableElement).build().perform();
    }
    public void navigateToWidget() {
        wait.until(ExpectedConditions.visibilityOf(navigateWidget));
        navigateWidget.click();

        wait.until(ExpectedConditions.visibilityOf(listmenu));
        action.sendKeys(Keys.PAGE_DOWN).build().perform();

        wait.until(ExpectedConditions.visibilityOf(moveToItem));
        action.moveToElement(moveToItem);

        wait.until(ExpectedConditions.visibilityOf(clickTooltips));
        action.click(clickTooltips).build().perform();
    }
}
