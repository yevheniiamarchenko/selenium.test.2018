package tests.ui;

import base.BaseTest;
import objects.CalculatorPage;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class CalculatorButtonsShouldExistTest extends BaseTest {
    private static CalculatorPage calc;

    @Parameterized.Parameter
    public String button;

    @BeforeClass
    public static void setup() {
        calc = new CalculatorPage(driver);
        calc.open();
    }

    @Test
    public void calculator_ButtonsShouldExistTest() {

        Assert.assertTrue(calc.ifElementExist(button));
    }

    @Parameterized.Parameters(name = "Test: {0}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"0"},
                {"1"},
                {"2"},
                {"3"},
                {"4"},
                {"5"},
                {"6"},
                {"7"},
                {"8"},
                {"9"},
                {"0"},
                {"+"},
                {"-"},
                {"x"},
                {"/"},
                {"="},
                {"C"},
                {"."},
                {"resultsbox"}
        });

    }

    @AfterClass
    public static void stop() {
        driver.quit();
    }
}