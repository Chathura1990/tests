package pages;

import org.openqa.selenium.By;

public class UsersPage extends BasePage {

    public UsersPage() {
        super(By.xpath("//h1[text()='Not Found']"), "Users page");
    }
}
