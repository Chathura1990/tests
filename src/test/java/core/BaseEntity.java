package core;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseEntity {
    protected static Logger logger = Logger.getInstance();
    protected static Browser browser = Browser.getInstance();

    @BeforeClass
    public void before() {
        browser = Browser.getInstance();
        browser.navigate(Constants.BASE_URL);

    }

    @AfterClass
    public void after() {
        if (browser.isBrowserAlive()) {
            browser.exit();
        }
    }
}
