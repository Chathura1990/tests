package tests;

import core.BaseTest;
import core.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DropdownPage;
import pages.WelcomePage;

public class DropdownPageTest extends BaseTest {
    private final Logger logger = Logger.getInstance();
    private DropdownPage dropdownPage;

    @BeforeClass
    public void init() {
        WelcomePage.choosePage("/dropdown");
    }

    @BeforeMethod
    public void initInstancePage() {
        dropdownPage = new DropdownPage();
    }

    @Test(testName = "User can select necessary option")
    public void userCanSelectNecessaryOption() {
        String value = "1";

        logger.step("Selecting an option from the dropdown list");
        dropdownPage.setOption(value);

        logger.step("Checking if the correct option is selected");
        Assert.assertTrue(dropdownPage.isSelectCorrectOption(value),
                "Wrong option selected");
    }
}
