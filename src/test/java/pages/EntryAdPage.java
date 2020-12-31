package pages;

import core.elements.Button;
import core.elements.Label;
import org.openqa.selenium.By;

public class EntryAdPage extends BasePage {
    private final Button buttonClose = new Button(By.xpath("//div[@class='modal-footer']"),
            "button close modal window");
    private final Button buttonReturnModal = new Button(By.xpath("//a[@id='restart-ad']"),
            "button return modal window");
    private final Label modalWindow = new Label(By.xpath("//div[@id='modal']"),
            "modal window");

    public EntryAdPage() {
        super(By.xpath("//h3[text()='Entry Ad']"), "Entry ad page");
    }

    public void closeWindow() {
        buttonClose.click();
    }

    public void waitUntilModalLoad() {
        buttonClose.waitForElementIsClickable();
    }

    public boolean isModalDisplayed() {
        return modalWindow.isDisplayBlock();
    }

    public void returnModalWindow() {
        buttonReturnModal.click();
    }
}
