package calc.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;
import calc.utilities.Constants;

import java.io.File;

public class CalculatorPage extends CalculatorControls{

    WebDriver driver;

    public CalculatorPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step
    public String calculate(String expression) {
        for (int i = 0; i < expression.length(); i++) {
            driver.findElement(By.name("" + expression.charAt(i) + "")).click();
        }
        driver.findElement(button_equal).click();
        return driver.findElement(result_box).getAttribute("value");
    }

    @Step
    public void open() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(Constants.globalPath).getFile());
        driver.get("file:///" + file.getAbsolutePath());
    }


    @Step
    public void clear() {
        driver.findElement(button_clear).click();
    }
}
