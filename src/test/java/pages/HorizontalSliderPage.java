package pages;

import core.elements.Label;
import core.elements.Slider;
import org.openqa.selenium.By;

public class HorizontalSliderPage extends BasePage {
    private final Slider slider = new Slider(By.xpath("//input"), "slider");
    private final Label range = new Label(By.xpath("//span[@id='range']"), "range");

    public HorizontalSliderPage() {
        super(By.xpath("//h3[text()='Horizontal Slider']"),
                "Horizontal slider page");
    }

    public void moveSlider(int percent) {
        slider.moveSliderToPercent(percent);
    }

    public String getRange() {
        return range.getTextFromElement();
    }
}
