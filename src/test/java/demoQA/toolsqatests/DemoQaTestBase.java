package demoQA.toolsqatests;

import demoQA.demoqapages.DemoQaNavigationPage;
import mainbase.TestBase;

public class DemoQaTestBase extends TestBase {
    static final String DEMO_QA_URL = "https://demoqa.com/";
    public DemoQaNavigationPage goToNavigationPage() {
        getDriver().get(DEMO_QA_URL);
        return new DemoQaNavigationPage(getDriver());
    }
}
