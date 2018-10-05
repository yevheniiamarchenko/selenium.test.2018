package tests.functional.operations;

import base.BaseTest;
import objects.CalculatorPage;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.*;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class CalculatorDivisionOperationTest extends BaseTest {

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
    public void calculator_DivisionOperationTest() {
        Assert.assertEquals(expected, calc.calculate(expression));
    }

    @Parameterized.Parameters(name = "Test: {0}={1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"1/2", "0.5"},
                {"-1/2", "-0.5"},
                {"0/56", "0"},
                {"0.01/0.01", "1"},
                {"-0.01/0.01", "-1"},
                {"0.01/10", "0.001"},
                {"-0.01/10", "-0.001"},
                {"-1234567890123456789012345/12345678901234567890123456", "-0.1"},
                {"-1234567890123456789012345/0.00000000000000000000000001", "-1.2345678901234569e+50"},
                {"0.00000000000000000000000001/12345678901234567890123456","8.100000072900001e-52"},
                {"-0.00000000000000000000000001/12345678901234567890123456","-8.100000072900001e-52"},
                {"1/0","Infinity"},
                {"-1/0","-Infinity"},
                {"0/0","The result is undetermined"}

        });
    }

    @AfterClass
    public static void stop() {
        driver.quit();
    }
}
