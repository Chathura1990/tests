package tests;

import core.BaseTest;
import core.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.NotificationMessagePage;
import pages.WelcomePage;

public class NotificationMessagePageTest extends BaseTest {
    private final Logger logger = Logger.getInstance();
    private NotificationMessagePage notificationMessagePage;

    @BeforeClass
    public void init() {
        WelcomePage.choosePage("/notification_message");
    }

    @BeforeMethod
    public void initInstancePage() {
        notificationMessagePage = new NotificationMessagePage();
    }

    @Test(testName = "User can click on the button until the message is successful")
    public void userCanClickButtonUntilUnsuccessful() {
        notificationMessagePage.clickUntilUnsuccessful();

        logger.step("Checking if the notification message is successful");
        Assert.assertTrue(notificationMessagePage.getMessage().contains("Action successful"),
                "Notification message is unsuccessful");
    }
}
