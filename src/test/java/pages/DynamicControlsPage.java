package pages;

import core.elements.Button;
import core.elements.CheckBox;
import core.elements.TextField;
import org.openqa.selenium.By;

public class DynamicControlsPage extends BasePage {
    private final String locatorForFormInput = "//form[@id='input-example']";

    private final CheckBox checkBox = new CheckBox(By.xpath("//input[@id='checkbox']"),
            "checkbox");
    private final Button buttonRemoveAdd = new Button(By.xpath("//form[@id='checkbox-example']/button"),
            "button remove/add");
    private final Button buttonEnableDisable = new Button(By.xpath(locatorForFormInput + "/button"),
            "button enable/disable");
    private final TextField inputField = new TextField(By.xpath(locatorForFormInput + "/input"),
            "input field");

    public DynamicControlsPage() {
        super(By.xpath("//h4[text()='Dynamic Controls']"),
                "Dynamic controls page");
    }

    public void clickRemove() {
        buttonRemoveAdd.click();
    }

    public void clickAdd() {
        buttonRemoveAdd.click();
    }

    public boolean isNecessaryButton(String nameOfButton) {
        buttonRemoveAdd.waitForElementIsClickable();
        return buttonRemoveAdd.getTextFromElement().equals(nameOfButton);
    }

    public boolean isCheckBoxDisplayed() {
        return checkBox.isDisplayed();
    }

    public void clickEnable() {
        buttonEnableDisable.click();
    }

    public void clickDisable() {
        buttonEnableDisable.click();
    }

    public void inputText(String value) {
        buttonEnableDisable.waitForElementIsClickable();
        inputField.sendKeys(value);
    }

    public boolean isInputDisable() {
        buttonEnableDisable.waitForElementIsClickable();
        return inputField.isDisable();
    }
}
