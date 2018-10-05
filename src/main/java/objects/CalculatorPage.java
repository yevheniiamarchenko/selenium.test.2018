package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;
import utilities.Constants;

import java.io.File;

public class CalculatorPage extends CalculatorControls {

    WebDriver driver;

    public CalculatorPage(WebDriver driver) {
        this.driver = driver;
    }


    @Step
    public String calculate(String expression) {
        for (int i = 0; i < expression.length(); i++) {
            driver.findElement(By.xpath("//input[@name='" + expression.charAt(i) + "']")).click();
        }
        driver.findElement(button_equal).click();
        return driver.findElement(result_box).getAttribute("value");
    }

    @Step
    public String enterValue(String expression) {
        for (int i = 0; i < expression.length(); i++) {
            driver.findElement(By.xpath("//input[@name='" + expression.charAt(i) + "']")).click();
        }
        return driver.findElement(result_box).getAttribute("value");
    }

    @Step
    public String getValueResultBox() {
        return driver.findElement(result_box).getAttribute("value");
    }

    @Step
    public boolean ifElementExist(String expression) {
        return (driver.findElement(By.xpath("//input[@name='" + expression + "']")) != null);
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
