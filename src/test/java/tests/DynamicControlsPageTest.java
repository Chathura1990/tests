package tests;

import core.BaseTest;
import core.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DynamicControlsPage;
import pages.WelcomePage;

public class DynamicControlsPageTest extends BaseTest {
    private final Logger logger = Logger.getInstance();
    private DynamicControlsPage dynamicControlsPage;

    @BeforeClass
    public void init() {
        WelcomePage.choosePage("/dynamic_controls");
    }

    @BeforeMethod
    public void initInstancePage() {
        dynamicControlsPage = new DynamicControlsPage();
    }

    @Test(testName = "User can click on button remove and add")
    public void userCanClickRemoveAdd() {
        dynamicControlsPage.clickRemove();

        logger.step("Checking if the button has changed after clicking");
        Assert.assertTrue(dynamicControlsPage.isNecessaryButton("Add"),
                "The button was not pressed");

        dynamicControlsPage.clickAdd();

        logger.step("Checking if the checkbox appeared after clicking the button");
        Assert.assertTrue(dynamicControlsPage.isCheckBoxDisplayed(),
                "The checkbox was not added");
    }

    @Test(testName = "User can click on button enable and disable")
    public void userCanClickEnableDisable() {
        dynamicControlsPage.clickEnable();
        dynamicControlsPage.inputText("Veronika");

        logger.step("Checking if the text is available");
        Assert.assertFalse(dynamicControlsPage.isInputDisable(),
                "The button was not pressed");

        dynamicControlsPage.clickDisable();

        logger.step("Checking if the input became unavailable after clicking");
        Assert.assertTrue(dynamicControlsPage.isInputDisable(),
                "The input field was not disabled");
    }
}
