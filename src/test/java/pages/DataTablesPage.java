package pages;

import core.elements.Button;
import core.elements.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class DataTablesPage extends BasePage {
    private final String locatorForTable = "//table[@id='table%d']";

    public DataTablesPage() {
        super(By.xpath("//h3[text()='Data Tables']"), "Data tables page");
    }

    public String getValues(int numberOfTable) {
        Label table = new Label(By.xpath(String.format(locatorForTable, numberOfTable)),
                "table №" + numberOfTable);
        return table.getListOfElements().stream()
                .map(WebElement::getText)
                .collect(Collectors.joining(" "));
    }

    public List<String> getValuesFromColumn(int numberOfTable, String column) {
        Label values;
        if (numberOfTable == 1) {
            Button header = new Button(By.xpath(String.format(locatorForTable + "//th//span", 1)), "header from table 1");

            List<String> listOfHeader = header.getListOfElements().stream().map(WebElement::getText).collect(Collectors.toList());

            int indexColumn = listOfHeader.indexOf(column);
            values = new Label(By.xpath(String.format(locatorForTable + "//tr//td[%d]", indexColumn)), "values from table 1");
        } else {
            values = new Label(By.xpath(String.format(locatorForTable + "//td[@class='%s']", column.replace(" ", "-").toLowerCase())), "values from table 2");
        }
        return values.getListOfElements().stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public void sortByColumn(int numberOfTable, String nameOfColumn) {
        new Button(By.xpath(String.format(locatorForTable + "//span[text()='%s']", numberOfTable,
                nameOfColumn)), "column " + nameOfColumn).click();
    }
}
