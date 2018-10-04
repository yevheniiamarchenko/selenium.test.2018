package functional;

import base.BaseTest;
import calc.objects.CalculatorPage;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.*;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class CalculatorMaxCharactersEnteringTest extends BaseTest {

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
    public void calculator_ShouldLeave26CharactersEnteredTest() {
        Assert.assertEquals(expected, calc.enterValue(expression));
    }

    @Parameterized.Parameters(name = "Test: {0}={1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"123456789012345678901234567", "12345678901234567890123456"},
                {"-12345678901234567890123456", "-1234567890123456789012345"},
                {"12345678901234567890.123456", "12345678901234567890.12345"},
                {"-12345678901234567890.12345", "-12345678901234567890.1234"},
                {"0.0000000000000000000000001", "0.000000000000000000000000"},
                {"-0.000000000000000000000001", "-0.00000000000000000000000"}
        });
    }

    @AfterClass
    public static void stop() {
        driver.quit();
    }
}
