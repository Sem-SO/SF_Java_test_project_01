import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.URL;

public class SimpleTest {

    public RemoteWebDriver browser;
    private static final String SELENIUM_URL = "http://localhost:4444/wd/hub";

    @BeforeTest
    public void start() throws Exception {
        this.browser = new RemoteWebDriver(
                new URL(SELENIUM_URL),
                new FirefoxOptions()
        );
    }

    @Test
    public void simpleTest() {
        this.browser.get("https://www.google.ru/");
        WebElement element = this.browser.findElementByCssSelector(".gLFyf.gsfi");
        element.click();
        element.sendKeys("Skillfactory");
        try {Thread.sleep(3000);} catch (Exception e) {}
        WebElement button = this.browser.findElementByCssSelector(".gNO89b");
        button.click();
        try {Thread.sleep(3000);} catch (Exception e) {}
        WebElement sfButton = this.browser.findElementByCssSelector(".LC20lb.DKV0Md");
        sfButton.click();


        try {Thread.sleep(10000);} catch (Exception e) {}

    }

    @AfterTest
    public void end() {
        this.browser.close();
    }
}
