package pages;

import core.elements.Button;
import core.elements.Label;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

public class JavascriptAlertsPage extends BasePage {
    private Alert alert;
    private final Label resultAction = new Label(By.xpath("//p[@id='result']"), "result");

    public JavascriptAlertsPage() {
        super(By.xpath("//h3[text()='Javascript Alerts']"),
                "Javascript alerts page");
    }

    public void clickButton(String nameOfNeededButton) {
        new Button(By.xpath(String.format("//button[@onclick='js%s()']", nameOfNeededButton)),
                "button " + nameOfNeededButton.toLowerCase()).click();
        alert = getAlert();
    }

    public void acceptAlert() {
        alert.accept();
    }

    public void dismissAlert() {
        alert.dismiss();
    }

    public void inputValue(String value) {
        alert.sendKeys(value);
        acceptAlert();
    }

    public boolean isCorrectAction(String message) {
        return resultAction.getTextFromElement().equals(message);
    }
}
