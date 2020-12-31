package tests;

import core.BaseTest;
import core.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.WelcomePage;

public class LoginPageTest extends BaseTest {
    private final Logger logger = Logger.getInstance();
    private LoginPage loginPage;

    @BeforeClass
    public void init() {
        WelcomePage.choosePage("/login");
    }

    @BeforeMethod
    public void initInstancePage() {
        loginPage = new LoginPage();
    }

    @Test(testName = "User can log in and log out")
    public void userCanLogInAndLogOut() {
        logger.step("Entering the correct username and password");
        loginPage.logIn("tomsmith", "SuperSecretPassword!");

        logger.step("Checking if you are logged in");
        Assert.assertTrue(loginPage.isLogIn(),
                "The log in has not been completed");

        loginPage.logOut();

        logger.step("Checking if you are logged out");
        Assert.assertTrue(loginPage.isLogout(),
                "The log out has not been completed");
    }

    @DataProvider(name = "userAndPassword")
    public Object[][] getUserAndPasswordTestData() {
        return new Object[][]{
                {"veronika", "1234"},
                {"tomsmith", ""},
                {"", "SuperSecretPassword!"},
                {"tomsmith", "1234"},
                {"veronika", "SuperSecretPassword!"}};
    }
    @Test(testName = "User can input incorrect user and password",
    dataProvider = "userAndPassword")
    public void userCanInputIncorrectData(String user, String password) {
        logger.step("Entering the incorrect username and password");
        loginPage.logIn(user, password);

        logger.step("Checking if you are logged in");
        Assert.assertTrue(loginPage.isLogout(),
                "The log in has been completed");
    }
}
