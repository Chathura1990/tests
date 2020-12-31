package core.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class Label extends BaseElement {

    public Label(By locator, String name) {
        super(locator, name);
    }

    public void moveToElement() {
        Actions builder = new Actions(browser.getDriver());
        builder.moveToElement(getElement()).perform();
    }
}
