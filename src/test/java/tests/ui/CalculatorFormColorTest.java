package tests.ui;

import objects.CalculatorPage;
import org.junit.*;
import org.openqa.selenium.By;
import base.BaseTest;

public class CalculatorFormColorTest extends BaseTest {

    private static CalculatorPage calc;



    @BeforeClass
    public static void setup() {
        calc = new CalculatorPage(BaseTest.driver);
        calc.open();
    }


    @Test
    public void calculator_FormColorTest() {
        String expectedColor = "linear-gradient(rgb(157, 210, 234), rgb(139, 206, 236))";
        String actualColor =  BaseTest.driver
                .findElement(By.xpath("//form[@name='board']"))
                .getCssValue("background-image").toString();
        Assert.assertEquals(expectedColor,actualColor);
    }


    @AfterClass
    public static void stop() {
        BaseTest.driver.quit();
    }
}
