package pages;

import core.elements.Button;
import core.elements.Dropdown;
import org.openqa.selenium.By;

public class DropdownPage extends BasePage {
    private final Dropdown select = new Dropdown(By.xpath("//select[@id='dropdown']"), "select button");

    public DropdownPage() {
        super(By.xpath("//h3[text()='Dropdown List']"), "Dropdown page");
    }

    public void setOption(String value) {
        select.selectValue(value);
    }

    public boolean isSelectCorrectOption(String value) {
        return Boolean.parseBoolean(getButtonOption(value).getElement().
                getAttribute("selected"));
    }

    private Button getButtonOption(String value) {
        return new Button(By.xpath(String.format("//option[@value='%s']", value)),
                "option №" + value);
    }
}
