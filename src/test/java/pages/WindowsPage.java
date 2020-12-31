package pages;

import core.elements.Button;
import org.openqa.selenium.By;

public class WindowsPage extends BasePage {
    private final Button openWindow = new Button(By.xpath("//a[@href='/windows/new']"), "open new window");

    public WindowsPage() {
        super(By.xpath("//h3[text()='Opening a new window']"),
                "Opening a new window page");
    }

    public void click() {
        openWindow.click();
    }
}
