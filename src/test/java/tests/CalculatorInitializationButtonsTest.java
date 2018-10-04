import calc.objects.CalculatorPage;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class CalculatorInitializationButtonsTest extends BaseTest {
    private static CalculatorPage calc;

    @Parameterized.Parameter
    public String expression;

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
    public void calculator_InitializationTest() {

        Assert.assertTrue(calc.ifElementExist(expression));
    }

    @Parameterized.Parameters(name = "Test: {0}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"0"},
                {"1"},
                {"2"},
                {"3"},
                {"4"},
                {"5"},
                {"6"},
                {"7"},
                {"8"},
                {"9"},
                {"0"},
                {"+"},
                {"-"},
                {"x"},
                {"/"},
                {"="},
                {"C"},
                {"."},
                {"resultsbox"}
        });

    }

    @AfterClass
    public static void stop() {
        driver.quit();
    }
}