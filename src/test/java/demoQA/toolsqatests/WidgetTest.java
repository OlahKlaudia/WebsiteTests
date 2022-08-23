package demoQA.toolsqatests;

import demoQA.demoqapages.DemoQaNavigationPage;
import demoQA.demoqapages.WidgetPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
@Epic("DemoQA")
@Feature("DemoQA test")
public class WidgetTest extends DemoQaTestBase {
    private static final String HOVER_TEXT = "You hovered over the Button";
    private static final String HOVER_TEXT_FIELD = "You hovered over the text field";

    @DisplayName("Widget Test")
    @Step("Navigate to Tooltips\n" +
            "Hover to the `Hover me to see` button and check the text is `You hovered over the    Button`\n" +
            "Hover to the Text Field and check the text is `You hovered over the text field`\n")
    @Test
    public void widgetTest() {
        DemoQaNavigationPage navigationPage =goToNavigationPage();
        navigationPage.navigateToWidget();

        WidgetPage widget = new WidgetPage(getDriver());
        widget.checkHoverTexts();

        assertTrue(widget.getHoverButtonText().contains(HOVER_TEXT), "error message");
        assertTrue(widget.getHovertextField().contains(HOVER_TEXT_FIELD), "error message");
    }
}
