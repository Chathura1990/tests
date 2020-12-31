package core;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest extends BaseEntity {
    private final Logger logger = Logger.getInstance();

    @BeforeTest
    public void beforeTest() {
        Class currentClass = this.getClass();
        logger.logTestName(currentClass.getName());
    }

    @AfterTest
    public void afterTest() {
        Class currentClass = this.getClass();
        logger.logTestEnd(currentClass.getName());
    }
}
