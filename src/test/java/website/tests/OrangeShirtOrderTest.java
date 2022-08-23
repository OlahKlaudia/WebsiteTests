package website.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import website.orangeshirtpages.OrangeDataVerifyPage;
import website.orangeshirtpages.OrangeDataVerifyTablePage;
import website.orangeshirtpages.OrangeShirtOrderPage;
import org.junit.jupiter.api.Test;
import website.orangeshirtpages.VerifyAssertPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Web shop")
@Feature("Web shop test")
public class OrangeShirtOrderTest extends WebsiteTesBase {
    private static final String T_SHIRT_NAME = "Faded Short Sleeve T-shirts";
    private static final String T_SHIRT_ATTRIBUTE = "Orange, S";
    private static final String T_SHIRT_QUANTITY = "2";

    private static final String TSHIRT_NAME = "Faded Short Sleeve T-shirts";
    private static final String VERIFY_TSHIRT_ATTRIBUTE = "Color : Orange, Size : S";

    @DisplayName("Product order Test (S size, orange color) ")
    @Step("Click `T-shirts` item\n" +
            "Click `Faded Short Sleeve T-shirts` product\n" +
            "Select S size\n" +
            "Select orange color\n" +
            "Set quantity to 2\n" +
            "Click `Add to cart` button\n" +
            "Verify the data on the popup\n" +
            "Click `Proceed to checkout`\n" +
            "Verify the data in the result table\n" +
            "Click `Proceed to checkout`\n" +
            "Check the the sign in page is loaded\n")
    @Test
    public void orderOrangeShirtTest() {
        WebsiteTesBase websiteTesBase=new WebsiteTesBase();
        websiteTesBase.navigateToWebshopLandingPage();

        OrangeShirtOrderPage productOrderPage = new OrangeShirtOrderPage(getDriver());
        productOrderPage.clickTshirtHeader();
        productOrderPage.orderOrangeTshirt();

        VerifyAssertPage verifyAssertPage=new VerifyAssertPage(getDriver());
        assertTrue(verifyAssertPage.geCheckProductNameText().contains(T_SHIRT_NAME), "Incorrect data.");
        assertTrue(verifyAssertPage.getCheckProductAttributesText().contains(T_SHIRT_ATTRIBUTE), "Incorrect data.");
        assertTrue(verifyAssertPage.getCheckQuantityText().contains(T_SHIRT_QUANTITY), "Incorrect data.");

        OrangeDataVerifyPage verifyDataPage= new OrangeDataVerifyPage(getDriver());
        verifyDataPage.orangeDataVerify();

        assertTrue(verifyAssertPage.getCheckTableProductName().contains(TSHIRT_NAME), "Incorrect data.");
        assertTrue(verifyAssertPage.getCheckTableAttributesText().contains(VERIFY_TSHIRT_ATTRIBUTE), "Incorrect data.");
        assertTrue(verifyAssertPage.getCheckSignInButtonLoad().isDisplayed(), "Not found Sign In button");

        OrangeDataVerifyTablePage verifyTableDataPage= new OrangeDataVerifyTablePage(getDriver());
        verifyTableDataPage.orangeDataVerifyTable();
    }
}
