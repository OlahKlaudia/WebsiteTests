package demoQA.toolsqatests;

import demoQA.demoqapages.DemoQaNavigationPage;
import demoQA.demoqapages.UploadPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
@Epic("DemoQA")
@Feature("DemoQA test")
public class UploadTest extends DemoQaTestBase {

    @DisplayName("Upload File Test")
    @Step("Navigate to `Upload and Download` page\n" +
            "Select file from the disk\n" +
            "Click upload\n" +
            "Verify the content of the Alert `Thanks, you have selected “path” file to Upload`\n")
    @Test
    public void uploadTest() {
        DemoQaNavigationPage navigationPage =goToNavigationPage();
        navigationPage.navigateToElementUpload();

        UploadPage upload = new UploadPage(getDriver());
        upload.uploadFile();
    }
}
