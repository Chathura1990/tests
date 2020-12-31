package tests;

import core.BaseTest;
import core.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.EntryAdPage;
import pages.WelcomePage;

public class EntryAdPageTest extends BaseTest {
    private final Logger logger = Logger.getInstance();
    private EntryAdPage entryAdPage;

    @BeforeClass
    public void init() {
        WelcomePage.choosePage("/entry_ad");
    }

    @BeforeMethod
    public void initInstancePage() {
        entryAdPage = new EntryAdPage();
    }

    @Test(testName = "User can remove and add modal window")
    public void userCanRemoveAndAddModalWindow() {
        entryAdPage.closeWindow();

        logger.step("Page роорв ылды refresh");
        entryAdPage.refreshPage();

        logger.step("Checking if modal window appears after page refresh");
        Assert.assertFalse(entryAdPage.isModalDisplayed(),
                "The modal window was not disabled");


        entryAdPage.returnModalWindow();

        logger.step("Page refresh");
        entryAdPage.refreshPage();
        entryAdPage.waitUntilModalLoad();

        logger.step("Checking for a modal window to appear after clicking the return window button");
        Assert.assertTrue(entryAdPage.isModalDisplayed(),
                "The modal window was not add on window");
    }
}
