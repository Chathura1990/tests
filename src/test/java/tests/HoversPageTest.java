package tests;

import core.BaseTest;
import core.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HoversPage;
import pages.UsersPage;
import pages.WelcomePage;

public class HoversPageTest extends BaseTest {
    private final Logger logger = Logger.getInstance();
    private HoversPage hoversPage;

    @BeforeClass
    public void init() {
        WelcomePage.choosePage("/hovers");
    }

    @BeforeMethod
    public void initInstancePage() {
        hoversPage = new HoversPage();
    }

    @Test(testName = "User can choose user and click on view")
    public void userCanViewNecessaryUser() {
        int numberOfUser = 1;

        logger.step("Hover the mouse over the figure");
        hoversPage.moveToFigure(numberOfUser);

        logger.step("Checking if the text appeared after hovering");
        Assert.assertTrue(hoversPage.isDisplay(numberOfUser),
                "The user is not selected and the link does not appear");

        UsersPage hoversViewPage = hoversPage.clickToView(numberOfUser);

        logger.step("Check if a new page has appeared");
        Assert.assertTrue(hoversViewPage.isPageOpen(),
                "User review link not clicked");
    }
}
