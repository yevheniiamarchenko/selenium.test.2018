package functional;

import base.BaseTest;
import calc.objects.CalculatorPage;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.*;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class CalculatorAdditionOperationTest extends BaseTest {

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
    public void calculator_AdditionOperationTest() {
        Assert.assertEquals(expected, calc.calculate(expression));
    }

    @Parameterized.Parameters(name = "Test: {0}={1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"0+0", "0"},
                {"+0", "0"},
                {"+", "0"},
                {"-5+5", "0"},
                {"1.02+1.001", "2.021"},
                {"-0.02+0.01", "-0.01"},
                {"0.00000000000000000000000001+0.00000000000000000000000001","2e-26"},
                {"-0.0000000000000000000000001+0.0000000000000000000000001","0"},
                {"99999999999999999999999999+1","1e+26"}

        });
    }

    @AfterClass
    public static void stop() {
        driver.quit();
    }
}
