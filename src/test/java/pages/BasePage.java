package pages;

import core.Browser;
import core.elements.Label;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import java.util.Set;

abstract class BasePage {

    private By locator;
    private String name;
    Label elem;


    BasePage(By locator, String name) {
        this.locator = locator;
        this.name = name;
        elem = new Label(locator, name);
        waitUntilPageOpen();
    }

    private void waitUntilPageOpen() {
        try {
            elem.waitForIsElementPresent();
        } catch (Throwable e) {
            System.err.println("Page was not opened");
        }
    }

    public boolean isPageOpen() {
        return elem.isDisplayed();
    }

    public void refreshPage() {
        Browser.getInstance().refresh();
    }

    public Alert getAlert() {
        return Browser.getInstance().getDriver().switchTo().alert();
    }

    public Set<String> getWindowHandles() {
        return Browser.getInstance().getDriver().getWindowHandles();
    }

    public void returnBack() {
        Browser.getInstance().returnBackPage();
    }
}
