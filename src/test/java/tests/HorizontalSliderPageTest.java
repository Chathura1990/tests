package tests;

import core.BaseTest;
import core.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HorizontalSliderPage;
import pages.WelcomePage;

public class HorizontalSliderPageTest extends BaseTest {
    private final Logger logger = Logger.getInstance();
    private HorizontalSliderPage horizontalSliderPage;

    @BeforeClass
    public void init() {
        WelcomePage.choosePage("/horizontal_slider");
    }

    @BeforeMethod
    public void initInstancePage() {
        horizontalSliderPage = new HorizontalSliderPage();
    }

    @Test(testName = "User can move slider on page")
    public void userCanMoveSlider() {
        logger.step("Move the slider");
        horizontalSliderPage.moveSlider(90);

        logger.step("Checking if the slider has moved");
        Assert.assertEquals(horizontalSliderPage.getRange(), "3.5",
                "The slider was not moved");
    }
}
