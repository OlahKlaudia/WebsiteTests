package mainbase;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

abstract public class PageBase extends LoadableComponent<PageBase> {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Faker fake;
    protected Actions action;

    public PageBase(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        action = new Actions(driver);
        fake= new Faker();
        PageFactory.initElements(driver, this);
        this.get();
    }

    @Override
    protected void isLoaded() throws Error {
    }

    @Override
    protected void load() {
    }
}
