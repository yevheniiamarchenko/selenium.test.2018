
import org.junit.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

public class Hometask2 {

    private WebDriver driver;


    @Before
    public void createDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
    }

    @After
    public void quitDriver() {
        driver.quit();
    }

    @Test
    public void testGoogleSearch() {
        driver.get("http://www.google.com/");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium Webdriver");
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }
        WebElement button = driver.findElement(By.name("btnK"));
        button.submit();
        try {
            Thread.sleep(4500);
        } catch (Exception e) {
        }

    }
}