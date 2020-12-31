package tests;

import core.BaseTest;
import core.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DragDropPage;
import pages.WelcomePage;

public class DragDropPageTest extends BaseTest {
    private final Logger logger = Logger.getInstance();
    private DragDropPage dragDropPage;

    @BeforeClass
    public void init() {
        WelcomePage.choosePage("/drag_and_drop");
    }

    @BeforeMethod
    public void initInstancePage() {
        dragDropPage = new DragDropPage();
    }

    @Test(testName = "User can drag column and drop it")
    public void userCanDragAndDropColumn() {
        String column = "a";
        String targetColumn = "b";

        logger.step("Move one element to the place of another");
        dragDropPage.move(column, targetColumn);

        logger.step("Comparing item header");
        Assert.assertEquals(dragDropPage.getHeader(column), targetColumn.toUpperCase(),
                "Columns unchanged");
    }
}
