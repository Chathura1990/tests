package pages;

import core.elements.Button;
import core.elements.Label;
import org.openqa.selenium.By;

public class StatusCodesPage extends BasePage {
    private final Label currentStatusCode = new Label(By.xpath("//p"), "status code");
    private final Button buttonReturn = new Button(By.xpath("//a[@href='/status_codes']"),
            "button to return default status code");

    public StatusCodesPage() {
        super(By.xpath("//h3[text()='Status Codes']"), "Status codes page");
    }

    public void chooseStatusCode(int statusCode) {
        new Button(By.xpath(String.format("//a[@href='status_codes/%d']", statusCode)),
                "necessary status code").click();
    }

    public boolean isCorrectStatusCode(int statusCode) {
        return currentStatusCode.getTextFromElement().contains(String.valueOf(statusCode));
    }

    public void clickReturn() {
        buttonReturn.click();
    }

    public boolean isHomePage() {
        return new Button(By.xpath("//li"), "button set status code").isDisplayed();
    }
}
