package website.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import website.pages.ScreenshotOrangeDressPage;
@Epic("Web shop")
@Feature("Web shop test")
public class AutomationPracticeWebsiteTest extends WebsiteTesBase {

    @DisplayName("Create Screenshot Test")
    @Step("Create a screenshot of the element with the girl in the orange dress.\n")
    @Test
    public void automationPracticeWebsiteTest() {
        WebsiteTesBase websiteTesBase = new WebsiteTesBase();
        websiteTesBase.navigateToWebshopLandingPage();

        ScreenshotOrangeDressPage screenshotOrangeDressPage = new ScreenshotOrangeDressPage(getDriver());
        screenshotOrangeDressPage.createScreenshotOrangeDress();
    }
}
