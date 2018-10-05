package tests.functional.buttons;

import base.BaseTest;
import objects.CalculatorPage;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.*;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class CalculatorUsingDotButtonWithArithmeticOperationsResultTest extends BaseTest {

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
    public void calculator_UsingDotButtonAfterArithmeticOperationsTest() {
        calc.calculate(expression);
        calc.enterValue(".");
        String result = calc.getValueResultBox();
        Assert.assertEquals(expected, result);
    }

    @Parameterized.Parameters(name = "Test: {0} = {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"5+5","10."},
                {"-7+5","-2."},
                {"2/2","1."},
                {"1/4","0.25"},
                {"5x5","25."},
                {"0.5x0.5","0.25"},
                {"1.25-1.15","0.15"},
                {"0.3+0.4","0.7"},
                {"12345678901234567890123456x12345678901234567890123456", "1.5241578753238839e+50"},
                {"-1234567890123456789012345x12345678901234567890123456", "-1.5241578753238838e+49"},
                {"0.00000000000000000000000001x0.00000000000000000000000001","1e-52"},
                {"-0.0000000000000000000000001x0.0000000000000000000000001","-1.0000000000000001e-50"},
                {"-1234567890123456789012345/12345678901234567890123456", "-0.1"},
                {"-1234567890123456789012345/0.00000000000000000000000001", "-1.2345678901234569e+50"},
                {"0.00000000000000000000000001/12345678901234567890123456","8.100000072900001e-52"},
                {"-0.00000000000000000000000001/12345678901234567890123456","-8.100000072900001e-52"},
                {"1/0","Infinity"},
                {"-1/0","-Infinity"},
                {"0/0","The result is undetermined"},
                {"0.00000000000000000000000001+0.00000000000000000000000001","2e-26"},
                {"-0.0000000000000000000000001+0.0000000000000000000000001","0."},
                {"99999999999999999999999999+1","1e+26"},
                {"-0.00000000000000000000000001-0.00000000000000000000000001","-2e-26"},
                {"-99999999999999999999999999-1","-1e+26"}
        });
    }

    @AfterClass
    public static void stop() {
        driver.quit();
    }
}
