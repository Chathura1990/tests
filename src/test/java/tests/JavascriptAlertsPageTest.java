package tests;

import core.BaseEntity;
import core.BaseTest;
import core.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.JavascriptAlertsPage;
import pages.WelcomePage;

public class JavascriptAlertsPageTest extends BaseTest {
    private final Logger logger = Logger.getInstance();
    private JavascriptAlertsPage javascriptAlertsPage;

    @BeforeClass
    public void init() {
        WelcomePage.choosePage("/javascript_alerts");
    }

    @BeforeMethod
    public void initInstancePage() {
        javascriptAlertsPage = new JavascriptAlertsPage();
    }

    @Test(testName = "User can click on alert button")
    public void userCanClickOnAlert() {
        javascriptAlertsPage.clickButton("Alert");

        BaseEntity.logger.step("Click accept to alert");
        javascriptAlertsPage.acceptAlert();

        BaseEntity.logger.step("Checking if accept was clicked");
        Assert.assertTrue(javascriptAlertsPage.isCorrectAction("You successfuly clicked an alert"),
                "Accept button was not clicked");
    }

    @Test(testName = "User can click on confirm button")
    public void userCanClickOnConfirm() {
        String nameOfButton = "Confirm";
        String message = "You clicked: ";

        javascriptAlertsPage.clickButton(nameOfButton);

        logger.step("Click ok to confirm");
        javascriptAlertsPage.acceptAlert();

        logger.step("Checking if ok was clicked");
        Assert.assertTrue(javascriptAlertsPage.isCorrectAction(message + "Ok"),
                "Accept button was not clicked");

        javascriptAlertsPage.clickButton(nameOfButton);

        logger.step("Click cancel to confirm");
        javascriptAlertsPage.dismissAlert();

        logger.step("Checking if cancel was clicked");
        Assert.assertTrue(javascriptAlertsPage.isCorrectAction(message + "Cancel"),
                "Dismiss button was not clicked");
    }

    @Test(testName = "User can click on prompt button")
    public void userCanClickOnPrompt() {
        String value = "555";

        javascriptAlertsPage.clickButton("Prompt");

        logger.step("Input value to prompt");
        javascriptAlertsPage.inputValue(value);

        logger.step("Checking the inputted text");
        Assert.assertTrue(javascriptAlertsPage.isCorrectAction("You entered: " + value),
                "Wrong output value");
    }
}
