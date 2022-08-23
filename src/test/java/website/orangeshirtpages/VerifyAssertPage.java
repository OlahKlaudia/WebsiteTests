package website.orangeshirtpages;

import mainbase.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class VerifyAssertPage extends PageBase {
    @FindBy(css = "#layer_cart_product_title")
    private WebElement checkProductName;
    @FindBy(css = "#layer_cart_product_attributes")
    private WebElement checkProductAttributes;
    @FindBy(css = "#layer_cart_product_quantity")
    private WebElement checkQuantity;

    @FindBy(css = "#SubmitLogin")
    private WebElement checkSignInButtonLoad;
    @FindBy(css = ".cart_description .product-name a")
    private WebElement checkTableProductName;
    @FindBy(css = ".cart_description small a")
    private WebElement checkTableAttributes;
    @FindBy(css = "layer_cart")
    private WebElement layer;
    public VerifyAssertPage(WebDriver driver) {
        super(driver);
    }
    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
    layer.isDisplayed();
    }
    public String geCheckProductNameText(){
        return checkProductName.getText();
    }
    public String getCheckProductAttributesText(){
        return checkProductAttributes.getText();
    }
    public String getCheckQuantityText(){
        return checkQuantity.getText();
    }
    public String getCheckTableProductName(){
        wait.until(ExpectedConditions.visibilityOf(checkTableProductName));
        return checkTableProductName.getText();
    }
    public String getCheckTableAttributesText(){
        wait.until(ExpectedConditions.visibilityOf(checkTableAttributes));
        return checkTableAttributes.getText();
    }
    public WebElement getCheckSignInButtonLoad(){
        wait.until(ExpectedConditions.visibilityOf(checkSignInButtonLoad));
        return checkSignInButtonLoad;
    }
}
