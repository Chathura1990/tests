package core.elements;

import org.openqa.selenium.By;

public class Frame extends BaseElement {

    public Frame(By locator, String elementName) {
        super(locator, elementName);
    }

    public void switchToFrame() {
        browser.getDriver().switchTo().frame(getElement());
    }

    public void switchToDefault() {
        browser.getDriver().switchTo().defaultContent();
    }
}
