package tests.functional.buttons;

import base.BaseTest;
import objects.CalculatorPage;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.*;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class CalculatorEqualButtonAfterEnteringNumbersTest extends BaseTest {

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
    public void calculator_EqualButtonAfterEnteringNumbersTest() {
        Assert.assertEquals(expected, calc.calculate(expression));
    }

    @Parameterized.Parameters(name = "Test: {0} = {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"0","0"},
                {"1","1"},
                {"12345678901234567890123456", "12345678901234567890123456"},
                {"-1234567890123456789012345", "-1234567890123456789012345"},
                {"12345678901234567890.12345", "12345678901234567890.12345"},
                {"-12345678901234567890.1234", "-12345678901234567890.1234"},
        });
    }

    @AfterClass
    public static void stop() {
        driver.quit();
    }
}
