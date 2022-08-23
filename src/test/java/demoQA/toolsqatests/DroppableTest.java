package demoQA.toolsqatests;

import demoQA.demoqapages.DemoQaNavigationPage;
import demoQA.demoqapages.DroppablePage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
@Epic("DemoQA")
@Feature("DemoQA test")
public class DroppableTest extends DemoQaTestBase {

    @DisplayName("Droppable rectangle Test")
    @Step("-Navigate to `Droppable` page\n- Drop the smaller rectangle to the bigger one \n- Check the bigger rectangle is steelblue")
    @Test
    public void droppableTest() {
        DemoQaNavigationPage navigationPage =goToNavigationPage();
        navigationPage.navigateToInteraction();

        DroppablePage droppable = new DroppablePage(getDriver());
        droppable.dragAndDropItem();

        assertTrue(droppable.color().contains(droppable.fromStringToRgba()), "Not the same data.");
    }
}
