package pages;

import core.elements.Figure;
import core.elements.Label;
import org.openqa.selenium.By;

public class DragDropPage extends BasePage {
    private final String locatorForColumn = "//div[@id='column-%s']//header";

    public DragDropPage() {
        super(By.xpath("//h3[text()='Drag and Drop']"), "Drag and drop page");
    }

    public void move(String nameColumn, String nameTargetColumn) {
        Figure column = new Figure(By.xpath(String.format(locatorForColumn, nameColumn)), "column " + nameColumn);
        Figure targetColumn = new Figure(By.xpath(String.format(locatorForColumn, nameTargetColumn)), "target column " + nameColumn);

        column.moveFigure(targetColumn);
    }

    public String getHeader(String nameOfColumn) {
        return new Label(By.xpath(String.format("//div[@id='column-%s']//header", nameOfColumn)),
                "header of column " + nameOfColumn).getTextFromElement();
    }
}
