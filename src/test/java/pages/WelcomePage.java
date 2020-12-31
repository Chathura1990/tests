package pages;

import core.elements.Button;
import org.openqa.selenium.By;

public class WelcomePage extends BasePage {

    public WelcomePage() {
        super(By.xpath("//h1[text()='Welcome to the-internet']"), "Welcome page");
    }

    public static void choosePage(String href) {
        Button linkToPage = new Button(By.xpath(String.format("//a[@href='%s']", href)), "page link");
        linkToPage.click();
    }
}
