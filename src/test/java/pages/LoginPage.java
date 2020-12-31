package pages;

import core.elements.Button;
import core.elements.TextField;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    private final TextField loginInput = new TextField(By.xpath("//input[@id='username']"),
            "input login");
    private final TextField passwordInput = new TextField(By.xpath("//input[@id='password']"),
            "input password");

    private final Button buttonLogin = new Button(By.xpath("//form[@id='login']//button"),
            "login button");
    private final Button buttonLogout = new Button(By.xpath("//a[@href='/logout']"),
            "logout button");

    public LoginPage() {
        super(By.xpath("//h2[text()='Login Page']"), "Login page");
    }

    public void logIn(String login, String password) {
        loginInput.sendKeys(login);
        passwordInput.sendKeys(password);

        buttonLogin.click();
    }

    public void logOut() {
        buttonLogout.click();
    }

    public boolean isLogIn() {
        return buttonLogout.isDisplayed();
    }

    public boolean isLogout() {
        return buttonLogin.isDisplayed();
    }
}
