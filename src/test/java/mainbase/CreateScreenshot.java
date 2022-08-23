package mainbase;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class CreateScreenshot extends TestBase {
    private static final String SCREENSHOT_FOLDER = ".\\target\\screnshots\\";
    private static final Random RANDOM_NUMBER = new Random();
    private static final String SCREENSHOT_NAME = "Error" + RANDOM_NUMBER.nextInt() + ".png";

    public void createScreenshot(WebDriver driver, final String screenshotName) {
        File SrcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(SrcFile, new File(SCREENSHOT_FOLDER + "_" + screenshotName + "_" + SCREENSHOT_NAME));
            Allure.addAttachment("Any text", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    @Attachment("Screenshot on failure")
    public byte[] createScreenshot() {
        return ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BYTES);
    }
    public void createScreenshot(WebDriver driver) {
        createScreenshot(driver, SCREENSHOT_NAME);
    }
}
