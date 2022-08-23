package demoQA.toolsqatests;

import demoQA.demoqapages.DemoQaNavigationPage;
import demoQA.demoqapages.DynamicPropertyPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;
@Epic("DemoQA")
@Feature("DemoQA test")
public class DynamicPropertyTest extends DemoQaTestBase {
    private static final String CHECK_TEXT = "This text has random Id";

    @DisplayName("Dynamic Property Test")
    @Step("-Navigate to Dynamic Properties\nCheck the text is “This text has random Id”\n" +
            "Wait five seconds and check button is enabled\n" +
            "Check if the button text color is red\n" +
            "Check if the \"Visible After 5 Seconds\" button is visible\n")
    @Test
    public void dynamicPropertyTest() {
        DemoQaNavigationPage navigationPage =goToNavigationPage();
        navigationPage.navigateToElements();

        DynamicPropertyPage dynamicProperty = new DynamicPropertyPage(getDriver());

        assertTrue(dynamicProperty.checkParagraphName().contains(CHECK_TEXT), "Not the same data.");
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        assertTrue(dynamicProperty.checkButtonIsVisible().isDisplayed(), "Is not visible.");
        assertTrue(dynamicProperty.fromStringToRgba().contains(dynamicProperty.getColor()), "Not the same color.");
    }
}
