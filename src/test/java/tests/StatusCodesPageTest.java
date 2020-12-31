package tests;

import core.BaseTest;
import core.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.StatusCodesPage;
import pages.WelcomePage;

public class StatusCodesPageTest extends BaseTest {
    private final Logger logger = Logger.getInstance();
    private StatusCodesPage statusCodesPage;

    @BeforeClass
    public void init() {
        WelcomePage.choosePage("/status_codes");
    }

    @BeforeMethod
    public void initInstancePage() {
        statusCodesPage = new StatusCodesPage();
    }

    @Test(testName = "User can set necessary status code")
    public void userCanSetStatusCode() {
        int statusCode = 200;

        statusCodesPage.chooseStatusCode(statusCode);

        logger.step("Checking if the status of the page code has changed");
        Assert.assertTrue(statusCodesPage.isCorrectStatusCode(statusCode),
                "Wrong status code set");

        statusCodesPage.clickReturn();

        logger.step("Checking whether you have returned to the default page");
        Assert.assertTrue(statusCodesPage.isHomePage(),
                "Home page did not go");
    }
}
