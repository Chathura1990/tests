package core.elements;

import com.google.common.base.Function;
import core.Browser;
import core.Constants;
import core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class BaseElement {
    public static Browser browser = Browser.getInstance();
    private static Logger logger = Logger.getInstance();
    RemoteWebElement element;
    private By locator;
    private String name;

    public BaseElement(By locator, String elementName) {
        this.locator = locator;
        name = elementName;
    }

    public static void waitUntilFunction(Function<WebDriver, Boolean> function) {
        FluentWait<WebDriver> webDriverWait = new FluentWait<>(browser.getDriver());
        webDriverWait.withTimeout(60, TimeUnit.SECONDS).pollingEvery(100, TimeUnit.MILLISECONDS);
        webDriverWait.until(function);
    }

    public RemoteWebElement getElement() {
        waitForIsElementPresent();
        return element;
    }

    public String getTextFromElement() {
        return browser.getDriver().findElement(locator).getText();
    }

    public List<WebElement> getListOfElements() {
        return browser.getDriver()
                .findElements(locator);
    }

    public void waitForIsElementPresent() {
        isPresent(Constants.DEFAULT_TIMEOUT);
        if (!element.isDisplayed()) {
            element = (RemoteWebElement) browser.getDriver().findElement(locator);
        }
        assertTrue(element.isDisplayed(), "Element is not presented");
    }

    public By getLocator() {
        return locator;
    }

    public void click() {
        waitForElementIsClickable();
        logger.info(String.format("Click on %s element", name));
        element.click();
    }

    public void sendKeys(String value) {
        logger.info(String.format("Send <%s> value to %s element", value, name));
        browser.getDriver()
                .findElement(locator)
                .sendKeys(value);
    }

    public void clear() {
        logger.info(String.format("Clear value from %s element", name));
        browser.getDriver()
                .findElement(locator)
                .clear();
    }

    public void waitForElementIsClickable() {
        waitForIsElementPresent();
        new WebDriverWait(browser.getDriver(), Constants.DEFAULT_TIMEOUT)
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    public boolean isEnabled() {
        return browser.getDriver()
                .findElement(locator)
                .isEnabled();
    }

    public boolean isDisplayed() {
        return browser.getDriver().findElement(locator).isDisplayed();
    }

    public boolean isDisplayBlock() {
        return browser.getDriver()
                .findElement(locator).getAttribute("style").contains("display: block");
    }

    public boolean isDisable() {
        return Boolean.parseBoolean(browser.getDriver()
                .findElement(locator).getAttribute("disabled"));
    }

    public boolean isPresent(int timeout) {
        WebDriverWait wait = new WebDriverWait(Browser.getInstance().getDriver(), timeout);
        browser.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        try {
            wait.until((ExpectedCondition<Boolean>) driver -> {
                try {
                    List<WebElement> list = driver.findElements(locator);
                    for (WebElement el : list) {
                        if (el instanceof RemoteWebElement && el.isDisplayed()) {
                            element = (RemoteWebElement) el;
                            return element.isDisplayed();
                        }
                    }
                    element = (RemoteWebElement) driver.findElement(locator);
                } catch (Exception e) {
                    logger.warn(String.format("Element %s is not presented", name));
                    return false;
                }
                return element.isDisplayed();
            });
        } catch (Exception e) {
            return false;
        }
        try {
            browser.getDriver().manage()
                    .timeouts().implicitlyWait(Constants.DEFAULT_TIMEOUT, TimeUnit.SECONDS);
            return element.isDisplayed();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
