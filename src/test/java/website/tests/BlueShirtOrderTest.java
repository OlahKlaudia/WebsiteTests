package website.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import website.orangeshirtpages.VerifyAssertPage;
import website.pages.BlueShirtOrderPage;
import website.pages.VerifyDataPage;
import website.pages.VerifyTableDataPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Web shop")
@Feature("Web shop test")
public class BlueShirtOrderTest extends WebsiteTesBase {

    private static final String TSHIRT_NAME = "Faded Short Sleeve T-shirts";
    private static final String TSHIRT_ATTRIBUTE = "Blue, M";
    private static final String TSHIRT_QUANTITY = "2";
    private static final String VERIFY_TSHIRT_ATTRIBUTE = "Color : Blue, Size : M";

    @DisplayName("Product order test (M size, blue color) Test")
    @Step("Click `T-shirts` item\n" +
            "Click `Faded Short Sleeve T-shirts` product\n" +
            "Select M size\n" +
            "Select blue color\n" +
            "Set quantity to 2\n" +
            "Click `Add to cart` button\n" +
            "Verify the data on the popup\n" +
            "Click `Proceed to checkout`\n" +
            "Verify the data in the result table\n" +
            "Click `Proceed to checkout`\n" +
            "Check the the sign in page is loaded\n")
    @Test
    public void productOrderTest() {
        WebsiteTesBase websiteTesBase=new WebsiteTesBase();
        websiteTesBase.navigateToWebshopLandingPage();
        BlueShirtOrderPage productOrderPage = new BlueShirtOrderPage(getDriver());
        productOrderPage.clickTshirtsInHeader();
        productOrderPage.orderBlueTshirt();

        VerifyAssertPage verifyAssertPage=new VerifyAssertPage(getDriver());
        assertTrue(verifyAssertPage.geCheckProductNameText().contains(TSHIRT_NAME), "Incorrect data.");
        assertTrue(verifyAssertPage.getCheckProductAttributesText().contains(TSHIRT_ATTRIBUTE), "Incorrect data.");
        assertTrue(verifyAssertPage.getCheckQuantityText().contains(TSHIRT_QUANTITY), "Incorrect data.");

        VerifyDataPage verifyDataPage =  new VerifyDataPage(getDriver());
        verifyDataPage.verifyTheData();

        assertTrue(verifyAssertPage.getCheckTableProductName().contains(TSHIRT_NAME), "Incorrect data.");
        assertTrue(verifyAssertPage.getCheckTableAttributesText().contains(VERIFY_TSHIRT_ATTRIBUTE), "Incorrect data.");
        assertTrue(verifyAssertPage.getCheckSignInButtonLoad().isDisplayed(), "Not found Sign In button");

        VerifyTableDataPage verifyTableDataPage =new VerifyTableDataPage(getDriver());
        verifyTableDataPage.verifyTableData();
    }
}
