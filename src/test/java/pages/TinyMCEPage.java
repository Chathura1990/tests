package pages;

import core.elements.Button;
import core.elements.Frame;
import core.elements.Label;
import core.elements.TextField;
import org.openqa.selenium.By;

public class TinyMCEPage extends BasePage {
    private final String locatorForFormat = "//p";

    private final Button buttonFile = new Button(By.xpath("//span[text()='File']"),
            "button file");
    private final Button buttonFormat = new Button(By.xpath("//span[text()='Format']"),
            "button format");
    private final Button buttonNewDocument = new Button(By.xpath("//div[contains(@class,'tox-menu-nav')]"),
            "button new document");
    private final TextField contentBlock = new TextField(By.xpath("//body[@id='tinymce']//p"),
            "input content");
    private final Frame frame = new Frame(By.xpath("//iframe[@id='mce_0_ifr']"), "frame");

    public TinyMCEPage() {
        super(By.xpath("//h3[text()='An iFrame containing the TinyMCE WYSIWYG Editor']"),
                "TinyMCE page");
    }

    public void createNewDocument() {
        goOutFrame();
        buttonFile.click();
        buttonNewDocument.waitForElementIsClickable();
        buttonNewDocument.click();
        goToFrame();
    }

    public void inputContent(String value) {
        contentBlock.sendKeys(value);
    }

    public void goToFrame() {
        frame.switchToFrame();
    }

    public void goOutFrame() {
        frame.switchToDefault();
    }

    public String getContent() {
        return contentBlock.getTextFromElement();
    }

    public void setFormat(String nameOfFormat) {
        frame.switchToDefault();
        buttonFormat.click();
        new Button(By.xpath(String.format("//div[@title = '%s']", nameOfFormat)),
                nameOfFormat + " format").click();
        frame.switchToFrame();
    }

    public void clearContent() {
        contentBlock.clear();
    }

    public boolean isFormat(String tegOfFormat) {
        return new Label(By.xpath(String.format(locatorForFormat + "//%s", tegOfFormat)),
                "Teg of format").isDisplayed();
    }

    public void setAlign(String nameOfAlign) {
        frame.switchToDefault();
        new Button(By.xpath(String.format("//button[@aria-label = '%s']", nameOfAlign)),
                nameOfAlign.toLowerCase()).click();
        frame.switchToFrame();
    }

    public boolean isAlign(String nameOfAlign) {
        Label align = new Label(By.xpath(locatorForFormat), "Teg of format");
        return align.getElement().getAttribute("style").
                equals(String.format("text-align: %s;", nameOfAlign));
    }

    public void setAction(String action) {
        frame.switchToDefault();
        new Button(By.xpath(String.format("//button[@title = '%s']", action)),
                action + " button").click();
        frame.switchToFrame();
    }
}
