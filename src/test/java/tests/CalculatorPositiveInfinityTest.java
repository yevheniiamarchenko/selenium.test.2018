
import calc.objects.CalculatorPage;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.*;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class CalculatorPositiveInfinityTest extends BaseTest {

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
        calc.calculate("1/0");
    }

    @Test
    public void calculator_AdditionTest() {
        Assert.assertEquals(expected, calc.calculate(expression));
    }

    @Parameterized.Parameters(name = "Test: {0}={1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"+0", "Infinity"},
                {"+0.5", "Infinity"},
                {"+0.0000000000000000000000006", "Infinity"},
                {"-0", "Infinity"},
                {"-0.0000000000000000000000006", "Infinity"},
                {"x4", "Infinity"},
                {"/4", "Infinity"},
                {"/0", "Infinity"},


        });
    }

    @AfterClass
    public static void stop() {
        driver.quit();
    }
}
