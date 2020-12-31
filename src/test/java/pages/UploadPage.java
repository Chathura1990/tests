package pages;

import core.elements.Button;
import core.elements.Label;
import core.elements.TextField;
import org.openqa.selenium.By;

import java.io.File;

public class UploadPage extends BasePage {
    private final Button buttonChooseFile = new Button(By.xpath("//input[@id='file-upload']"),
            "button choose file");
    private final Button buttonUploadFile = new Button(By.xpath("//input[@id='file-submit']"),
            "button upload file");

    private final Label uploadedFile = new Label(By.xpath("//div[@id='uploaded-files']"),
            "uploaded file");
    private final TextField dragDropUpload = new TextField(By.xpath("//input[contains(@class,'input')]"),
            "drag and drop upload file");
    private final Label dragDropUploadedFile = new Label(By.xpath("//div[contains(@class,'dz')]//span"),
            "drag and drop uploaded file");

    public UploadPage() {
        super(By.xpath("//h3[text()='File Uploader']"), "File uploader page");
    }

    public void uploadFile(String filePath) {
        buttonChooseFile.sendKeys(filePath);
        buttonUploadFile.click();
    }

    public String getUploadedFile() {
        return uploadedFile.getTextFromElement();
    }

    public void dropFile(String filePath) {
        File file = new File(filePath);
        dragDropUpload.sendKeys(file.getAbsolutePath());
    }

    public String getDropUploadedFile() {
        return dragDropUploadedFile.getTextFromElement();
    }
}
