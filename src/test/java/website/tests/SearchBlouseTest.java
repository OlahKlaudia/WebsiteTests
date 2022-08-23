package website.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import website.pages.SearchDescriptionPage;
import website.pages.SearchForBlousePage;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Web shop")
@Feature("Web shop test")
public class SearchBlouseTest extends WebsiteTesBase {
    private static final String PARAGRAPH_TEXT = "Short sleeved blouse with feminine draped sleeve detail.";

    @DisplayName("Search for 'blouse' Test")
    @Step("Enter `blouse` to the search field\n" +
            "In the results hover the first item and click on `Quick view`\n" +
            "Check if the description is `Short sleeved blouse with feminine draped sleeve detail.`\n")
    @Test
    public void searchBlouseTest() {
        WebsiteTesBase websiteTesBase=new WebsiteTesBase();
        websiteTesBase.navigateToWebshopLandingPage();

        SearchForBlousePage blousePage =new SearchForBlousePage(getDriver());
        blousePage.searchForBlouse();
        blousePage.clickFirstLink();

        SearchDescriptionPage descriptionPage = new SearchDescriptionPage(getDriver());
        descriptionPage.checkParagraphDescription();

        assertTrue(descriptionPage.getFindParagraphText().contains(PARAGRAPH_TEXT), "Not the same paragraph text");
    }
}
