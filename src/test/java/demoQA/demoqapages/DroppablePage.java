package demoQA.demoqapages;

import mainbase.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DroppablePage extends PageBase {
    @FindBy(css = "#draggable")
    private WebElement dragLittleRectangle;
    @FindBy(css = ".simple-drop-container #droppable")
    private WebElement dropToBiggerRectangle;

    public DroppablePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void load() {
    }

    @Override
    protected void isLoaded() throws Error {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(dragLittleRectangle));
    }
    public void dragAndDropItem() {

        action.dragAndDrop(dragLittleRectangle, dropToBiggerRectangle).build().perform();
    }
    public String color(){
        return dropToBiggerRectangle.getCssValue("color");
    }
    public String fromStringToRgba(){
        return Color.fromString(color()).asRgba();
    }
}
