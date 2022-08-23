package website.orangeshirtpages;

import mainbase.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OrangeShirtOrderPage extends PageBase {
    @FindBy(css = ".sf-menu li:nth-of-type(3) a[title='T-shirts']")
    private WebElement clickTheName;
    @FindBy(css = ".product-name[itemprop='url']")
    private WebElement clickFadedShortsSleeveTshirts;
    @FindBy(css = "a[name='Orange']")
    private WebElement colorOrange;
    @FindBy(css = "option[value='1']")
    private WebElement selectMSize;
    @FindBy(css = ".icon-plus")
    private WebElement quantityPlus;
    @FindBy(css = "button.exclusive span")
    private WebElement addToCartButton;
    private static final String URL_T_SHIRT_PAGE = "http://automationpractice.com/index.php?id_category=5&controller=category";

    public OrangeShirtOrderPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        driver.getCurrentUrl().contains(URL_T_SHIRT_PAGE);
    }

    public void clickTshirtHeader() {
        wait.until(ExpectedConditions.visibilityOf(clickTheName));
        clickTheName.click();
    }

    public void orderOrangeTshirt() {
        wait.until(ExpectedConditions.visibilityOf(clickFadedShortsSleeveTshirts));
        clickFadedShortsSleeveTshirts.click();
        colorOrange.click();
        selectMSize.click();
        quantityPlus.click();
        wait.until(ExpectedConditions.visibilityOf(addToCartButton));
        addToCartButton.click();
    }
}
