package website.pages;

import mainbase.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchForBlousePage extends PageBase {
    @FindBy(css = "#search_query_top")
    private WebElement searchInput;
    @FindBy(css = "button[name='submit_search']")
    private WebElement searchClick;
    @FindBy(css = "div .product-container")
    private WebElement visibility;
    @FindBy(css = ".product-container .quick-view")
    private WebElement openPage;
    private static final String URL_BLOUSE_PAGE = "http://automationpractice.com/index.php?controller=search&orderby=position&orderway=desc&search_query=blouse&submit_search=";

    public SearchForBlousePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        driver.getCurrentUrl().contains(URL_BLOUSE_PAGE);
    }

    public void searchForBlouse() {
        wait.until(ExpectedConditions.visibilityOf(searchInput));
        searchInput.sendKeys("blouse");

        wait.until(ExpectedConditions.visibilityOf(searchClick));
        searchClick.click();
    }

    public void clickFirstLink() {
        wait.until(ExpectedConditions.visibilityOf(visibility));
        action.moveToElement(visibility).build().perform();

        wait.until(ExpectedConditions.visibilityOf(openPage));
        action.click(openPage).build().perform();
    }
}
