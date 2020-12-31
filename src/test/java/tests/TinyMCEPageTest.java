package tests;

import core.BaseTest;
import core.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.TinyMCEPage;
import pages.WelcomePage;

public class TinyMCEPageTest extends BaseTest {
    private final Logger logger = Logger.getInstance();
    private TinyMCEPage tinyMCEPage;
    private final String value = "Veronika";

    @BeforeClass
    public void init() {
        WelcomePage.choosePage("/tinymce");

    }

    @BeforeMethod
    public void initInstancePage() {
        tinyMCEPage = new TinyMCEPage();
    }

    @Test(testName = "User can create new document")
    public void userCanCreateNewDocument() {
        logger.step("Inputting your own text into a document");
        tinyMCEPage.goToFrame();
        tinyMCEPage.clearContent();
        tinyMCEPage.inputContent(value);

        logger.step("Getting text from a document");
        String contentValue = tinyMCEPage.getContent();

        logger.step("Creating a new document");
        tinyMCEPage.createNewDocument();

        logger.step("Checking if a new document has been created");
        Assert.assertNotEquals(tinyMCEPage.getContent(), contentValue,
                "New document has not been created");
        tinyMCEPage.goOutFrame();
    }

    @Test(testName = "User can input own content")
    public void userCanInputContent() {
        logger.step("Inputting your own text into a document");
        tinyMCEPage.goToFrame();
        tinyMCEPage.clearContent();
        tinyMCEPage.inputContent(value);

        logger.step("Checking if the text from the document matches the entered text");
        Assert.assertEquals(tinyMCEPage.getContent(), value,
                "Entered text does not match");
        tinyMCEPage.goOutFrame();
    }

    @DataProvider(name = "format")
    public Object[][] getFormatTestData() {
        return new Object[][]{
                {"Bold", "strong"},
                {"Italic", "em"},
                {"Underline", "span"}};
    }

    @Test(testName = "User can change format of text",
            dataProvider = "format")
    public void userCanChangeFormat(String format, String tegOfFormat) {
        logger.step("Setting the style " + format);
        tinyMCEPage.goToFrame();
        tinyMCEPage.clearContent();
        tinyMCEPage.setFormat(format);

        logger.step("Inputting your own text into a document");
        tinyMCEPage.inputContent(value);

        logger.step("Checking if the correct style is set");
        Assert.assertTrue(tinyMCEPage.isFormat(tegOfFormat),
                "The required format has not been applied to the text");
        tinyMCEPage.goOutFrame();
    }

    @DataProvider(name = "align")
    public Object[][] getAlignTestData() {
        return new Object[][]{
                {"left", "Align left"},
                {"center", "Align center"},
                {"right", "Align right"},
                {"justify", "Justify"}};
    }

    @Test(testName = "User can change align of text",
            dataProvider = "align")
    public void userCanChangeAlign(String direction, String nameOfAlign) {
        logger.step("Inputting your own text into a document");
        tinyMCEPage.goToFrame();
        tinyMCEPage.clearContent();
        tinyMCEPage.inputContent(value);

        logger.step("Setting text alignment to the " + direction);
        tinyMCEPage.setAlign(nameOfAlign);

        logger.step("Checking if the alignment is correct");
        Assert.assertTrue(tinyMCEPage.isAlign(direction),
                "The required align has not been applied to the text");
        tinyMCEPage.goOutFrame();
    }

    @Test(testName = "User can change with help undo and redo")
    public void userCanDoUndoRedo() {
        logger.step("Inputting your own text into a document");
        tinyMCEPage.goToFrame();
        tinyMCEPage.clearContent();
        tinyMCEPage.inputContent(value);

        logger.step("Taking a step back");
        tinyMCEPage.setAction("Undo");

        logger.step("Checking if the text has changed");
        Assert.assertEquals(tinyMCEPage.getContent(), "",
                "Undo failed");

        logger.step("Taking a step forward");
        tinyMCEPage.setAction("Redo");

        logger.step("Checking if the text has changed");
        Assert.assertEquals(tinyMCEPage.getContent(), value,
                "Redo failed");
        tinyMCEPage.goOutFrame();
    }
}
