package pages;

import core.elements.BaseElement;
import core.elements.Button;
import core.elements.Label;
import org.openqa.selenium.By;

public class NotificationMessagePage extends BasePage {
    private final Label notificationMessage = new Label(By.xpath("//div[@id='flash']"),
            "notification message");
    private final Button buttonLoadMessage = new Button(By.xpath("//a[@href='/notification_message']"),
            "button to load a new message");

    public NotificationMessagePage() {
        super(By.xpath("//h3[text()='Notification Message']"), "Notification message page ");
    }

    public void clickUntilUnsuccessful() {
        BaseElement.waitUntilFunction(webDriver -> {
            buttonLoadMessage.click();
            return getMessage().contains("Action successful");
        });
    }

    public String getMessage() {
        return notificationMessage.getTextFromElement();
    }
}
