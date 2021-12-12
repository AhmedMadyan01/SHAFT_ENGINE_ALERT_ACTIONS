package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class TestBase {
    protected static WebDriver webDriver;
    public static WebDriverWait webDriverWait;

    @BeforeTest
    public void setDriver() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.navigate().to("http://the-internet.herokuapp.com/javascript_alerts");
        webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
    }

    @AfterTest
    public void tearDownDriver() {
        webDriver.quit();
    }
}
