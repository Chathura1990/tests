package core.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class Dropdown extends BaseElement {

    public Dropdown(By locator, String name) {
        super(locator, name);
    }

    public void selectValue(String value) {
        Select dropdown = new Select(getElement());
        dropdown.selectByValue(value);
    }

}
