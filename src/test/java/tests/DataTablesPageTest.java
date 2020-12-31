package tests;

import core.BaseTest;
import core.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DataTablesPage;
import pages.WelcomePage;

public class DataTablesPageTest extends BaseTest {
    private final Logger logger = Logger.getInstance();
    private DataTablesPage dataTablesPage;

    @BeforeClass
    public void init() {
        WelcomePage.choosePage("/tables");
    }

    @BeforeMethod
    public void initInstancePage() {
        dataTablesPage = new DataTablesPage();
    }

    @Test(testName = "User can sort table for column")
    public void userCanSortByColumnFromTable() {
        int numberOfTable = 2;
        String column = "Last Name";

        logger.step("Getting table values before sorting");
        String valuesBeforeSort = dataTablesPage.getValues(numberOfTable);

        logger.step(String.format("Sort the table by '%s'", column));
        dataTablesPage.sortByColumn(numberOfTable, column);

        logger.step("Comparison of table values before and after sorting");
        Assert.assertNotEquals(valuesBeforeSort, dataTablesPage.getValues(numberOfTable),
                "Sorting is not correct");
    }
}
