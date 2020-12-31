package tests;

import core.BaseTest;
import core.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.UploadPage;
import pages.WelcomePage;

import java.io.File;

public class UploadPageTest extends BaseTest {
    private final Logger logger = Logger.getInstance();
    private UploadPage uploadPage;
    private final File file = new File("src/test/resources/in.txt");

    @BeforeClass
    public void init() {
        WelcomePage.choosePage("/upload");
    }

    @BeforeMethod
    public void initInstancePage() {
        uploadPage = new UploadPage();
    }

    @Test(testName = "User can choose and load necessary file")
    public void userCanChooseAndLoadFile() {
        logger.step("Upload the file using the upload button");
        uploadPage.uploadFile(file.getAbsolutePath());

        logger.step("Checking if the file has been uploaded");
        Assert.assertEquals(uploadPage.getUploadedFile(), "in.txt",
                "The required file was not loaded");
        uploadPage.returnBack();
    }

    @Test(testName = "User can drag and drop necessary file")
    public void userCanDragAndDropFile() {
        logger.step("Upload the file using the drag and drop upload");
        uploadPage.dropFile(file.getAbsolutePath());

        logger.step("Checking if the file has been uploaded");
        Assert.assertEquals(uploadPage.getDropUploadedFile(), "in.txt",
                "The required file was not loaded");
    }
}
