package core.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class Slider extends BaseElement {
    private final Actions builder = new Actions(browser.getDriver());

    public Slider(By locator, String name) {
        super(locator, name);
    }

    public void moveSlide(int xTo, int yTo) {
        waitForIsElementPresent();
        builder.dragAndDropBy(getElement(), xTo, yTo).build().perform();
    }

    public void moveSliderToPercent(int percent) {
        int width = getElement().getSize().getWidth();
        builder.clickAndHold(getElement()).moveByOffset(-(width / 2), 0).
                moveByOffset((width / 100) * percent, 0).
                release().build().perform();
    }
}
