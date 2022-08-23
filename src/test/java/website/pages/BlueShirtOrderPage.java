package website.pages;

import mainbase.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BlueShirtOrderPage extends PageBase {
    @FindBy(css = ".sf-menu li:nth-of-type(3) a[title='T-shirts']")
    private WebElement clickTheName;
    @FindBy(css = ".product-name[itemprop='url']")
    private WebElement clickFadedShortsSleeveTshirts;
    @FindBy(css = "a[name='Blue']")
    private WebElement colorBlue;
    @FindBy(css = "option[value='2']")
    private WebElement selectMSize;
    @FindBy(css = ".icon-plus")
    private WebElement quantityPlus;
    @FindBy(css = "button.exclusive span")
    private WebElement addToCartButton;
    private static final String URL_T_SHIRT_PAGE = "http://automationpractice.com/index.php?id_category=5&controller=category";

    public BlueShirtOrderPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        driver.getCurrentUrl().contains(URL_T_SHIRT_PAGE);
    }

    public void clickTshirtsInHeader() {
        wait.until(ExpectedConditions.visibilityOf(clickTheName));
        clickTheName.click();
    }

    public void orderBlueTshirt() {
        wait.until(ExpectedConditions.visibilityOf(clickFadedShortsSleeveTshirts));
        clickFadedShortsSleeveTshirts.click();

        colorBlue.click();
        selectMSize.click();
        quantityPlus.click();

        wait.until(ExpectedConditions.visibilityOf(addToCartButton));
        addToCartButton.click();
    }
}
