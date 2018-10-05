package tests.functional.operations;

import base.BaseTest;
import objects.CalculatorPage;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.*;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class CalculatorMultiplicationOperationTest extends BaseTest {

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
    public void calculator_MultiplicationOperationTest() {
        Assert.assertEquals(expected, calc.calculate(expression));
    }

    @Parameterized.Parameters(name = "Test: {0}={1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"0x0", "0"},
                {"0x5","0"},
                {"5x0","0"},
                {"5x5", "25"},
                {"-5x5","-25"},
                {"12345678901234567890123456x12345678901234567890123456", "1.5241578753238839e+50"},
                {"-1234567890123456789012345x12345678901234567890123456", "-1.5241578753238838e+49"},
                {"0.00000000000000000000000001x0.00000000000000000000000001","1e-52"},
                {"-0.0000000000000000000000001x0.0000000000000000000000001","-1.0000000000000001e-50"},
                {"x0", "0"},
                {"x", "0"}
        });
    }

    @AfterClass
    public static void stop() {
        driver.quit();
    }
}
