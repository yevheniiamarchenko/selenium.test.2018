
import calc.objects.CalculatorPage;
import calc.utilities.WebDriverInitialization;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.*;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class CalculatorAdditionTest extends WebDriverInitialization{

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
    public void calculator_AdditionTest() {
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
                {"32785x2", "65570"},
                {"10000000/-1111", "-9000.900090009001"},
                {"2.02+0.01", "2.03"},
                {"-1+154", "153"}
        });
    }

    @AfterClass
    public static void stop() {
        driver.quit();
    }
}
