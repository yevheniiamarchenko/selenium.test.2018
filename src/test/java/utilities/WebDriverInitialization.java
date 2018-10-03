package utilities;

import org.junit.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;

import java.net.MalformedURLException;


public class WebDriverInitialization {

    protected static WebDriver driver;

    @BeforeClass
    public static void start() throws MalformedURLException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions().setHeadless(true);
        driver = new ChromeDriver(opt);
    }

    @AfterClass
    public static void stop() {
        driver.quit();
    }

}

