package pages;

import core.elements.Button;
import core.elements.Label;
import org.openqa.selenium.By;

public class HoversPage extends BasePage {
    private final String locatorToHrefUsers = "//div[@class='figcaption']//a[@href='/users/%d']";

    public HoversPage() {
        super(By.xpath("//h3[text()='Hovers']"), "Hovers page");
    }

    public void moveToFigure(int numberOfFigure) {
        new Label(By.xpath(String.format(locatorToHrefUsers + "//..//..", numberOfFigure)),
                "figure №" + numberOfFigure).moveToElement();
    }

    public boolean isDisplay(int numberOfUser) {
        Label nameUser = new Label(By.xpath(String.format(locatorToHrefUsers, numberOfUser)),
                "name of user №" + numberOfUser);
        return nameUser.isDisplayed();
    }

    public UsersPage clickToView(int numberOfUser) {
        Button viewUser = new Button(By.xpath(String.format(locatorToHrefUsers, numberOfUser)),
                "view of user №" + numberOfUser);
        viewUser.click();
        return new UsersPage();
    }
}
