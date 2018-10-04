import calc.objects.CalculatorPage;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.*;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class CalculatorClearTest extends BaseTest{

    private static CalculatorPage calc;

    @Parameterized.Parameter
    public String expression;


    @BeforeClass
    public static void setup() {
        calc = new CalculatorPage(driver);
        calc.open();
    }


    @Test
    public void calculator_ClearTest() {
        calc.calculate((expression));
        calc.clear();
        Assert.assertEquals("0", calc.getValueResultBox());
    }

    @Parameterized.Parameters(name = "Test: {0}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"0"},
                {"1234567890124567890123456"},
                {"-12345678901265.44444444"},
                {"1/3"},
                {"1/0"},
                {"-1/0"},
                {"0/0"},
                {"34--56/8x76+1234/0.3333x25"}
        });
    }

    @AfterClass
    public static void stop() {
        driver.quit();
    }
}
