package core.elements;

import core.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Figure extends BaseElement {
    private final JavascriptExecutor js = browser.getDriver();

    public Figure(By locator, String name) {
        super(locator, name);
    }

    public void moveFigure(Figure targetElement) {
        waitForIsElementPresent();
        File file = new File("src/test/resources/moveElement.js");
        try (FileReader fileReader = new FileReader(file.getAbsolutePath());
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String script = "";
            while (bufferedReader.ready()) {
                script += bufferedReader.readLine() + "\n";
            }
            System.out.println(script);

            js.executeScript(script, getElement(), targetElement.getElement());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
