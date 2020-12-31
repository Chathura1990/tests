package tests;

import core.BaseTest;
import core.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.WelcomePage;
import pages.WindowsPage;

public class WindowsPageTest extends BaseTest {
    private final Logger logger = Logger.getInstance();
    private WindowsPage windowsPage;

    @BeforeClass
    public void init() {
        WelcomePage.choosePage("/windows");
    }

    @BeforeMethod
    public void initInstancePage() {
        windowsPage = new WindowsPage();
    }

    @Test(testName = "User can open new window")
    public void userCanOpenNewWindow() {
        int countOfWindow = windowsPage.getWindowHandles().size();

        windowsPage.click();

        logger.step("Checking if a new window has opened");
        Assert.assertEquals(windowsPage.getWindowHandles().size(), countOfWindow + 1,
                "New window has not been opened");
    }
}
