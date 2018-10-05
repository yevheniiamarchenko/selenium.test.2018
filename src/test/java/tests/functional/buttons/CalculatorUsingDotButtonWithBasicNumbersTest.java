package tests.functional.buttons;

import base.BaseTest;
import objects.CalculatorPage;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.*;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class CalculatorUsingDotButtonWithBasicNumbersTest extends BaseTest {

    private static CalculatorPage calc;

    @Parameterized.Parameter
    public String expression;

    @Parameterized.Parameter(1)
    public String expected;

    @BeforeClass
    public static void setup() {
        calc = new CalculatorPage(driver);
        calc.open();
    }

    @Before
    public void cleanup() {
        calc.clear();
    }

    @Test
    public void calculator_UsingDotButtonWithBasicNumbersTest() {
        Assert.assertEquals(expected, calc.enterValue((expression)));
    }


    @Parameterized.Parameters(name = "Test: {0} = {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {".","0."},
                {"0.","0."},
                {"0.01","0.01"},
                {"-0.","-0."},
                {"-0.01","-0.01"},
                {"12345678901234567890123456.","12345678901234567890123456"},
                {"-1234567890123456789012345.","-1234567890123456789012345"},
                {"0.05.","0.05"},
                {"-0.07.","-0.07"},
                {"0.000000000000000000000001.","0.000000000000000000000001"},
                {"-0.00000000000000000000001.","-0.00000000000000000000001"},
                {"0..","0."}
        });
    }

    @AfterClass
    public static void stop() {
        driver.quit();
    }
}
