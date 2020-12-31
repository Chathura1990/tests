package core;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Browser {

    private static Browser instance;
    private static RemoteWebDriver driver;
    private static String OS = System.getProperty("os.name").toLowerCase();

    public static Browser getInstance() {
        if (instance == null) {
            try {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("headless");
                chromeOptions.addArguments("--no-sandbox");
                System.out.println(OS.toLowerCase());
                if (OS.startsWith("windows")) {
                    System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
                }else if (OS.startsWith("linux"))
                {
                    System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
                }
                driver = new ChromeDriver(chromeOptions);
                driver.manage().window().maximize();

            } catch (Exception e) {
                e.printStackTrace();
            }
            instance = new Browser();
        }
        return instance;
    }

    public RemoteWebDriver getDriver() {
        return driver;
    }

    public void navigate(String url) {
        driver.get(url);
    }

    public void refresh() {
        driver.navigate().refresh();
    }

    public void exit() {
        try {
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            instance = null;
        }
    }

    public void waitForPageToLoad() {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        try {
            wait.until((ExpectedCondition<Boolean>) new ExpectedCondition<Boolean>() {
                public Boolean apply(final WebDriver d) {
                    if (!(d instanceof JavascriptExecutor)) {
                        return true;
                    }
                    Object result = ((JavascriptExecutor) d)
                            .executeScript("return document['readyState'] ? 'complete' == document.readyState : true");
                    if (result instanceof Boolean && (Boolean) result) {
                        return true;
                    }
                    return false;
                }
            });
        } catch (Exception e) {
            System.err.println("Page is not loaded");
        }
    }

    public boolean isBrowserAlive() {
        return instance != null;
    }

    public boolean isCorrectUrl(String url) {
        System.out.println(driver.getCurrentUrl());
        return driver.getCurrentUrl().equals(url + "/");
    }

    public void returnBackPage() {
        driver.navigate().back();
    }

//    public void switchToPage(String page){
//        driver.switchTo()
//    }
}
