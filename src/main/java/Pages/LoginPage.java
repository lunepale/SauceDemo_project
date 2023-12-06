package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private final WebDriver driver;
    private final PageLocators locators;
    private WebElement usernameField;
    private WebElement passwordField;
    private WebElement loginButton;
    public LoginPage(WebDriver driver, PageLocators locators) {
        this.driver = driver;
        this.locators = locators;
    }

    public void initElements() {
        usernameField = driver.findElement(locators.getLocator("usernameField"));
        passwordField = driver.findElement(locators.getLocator("passwordField"));
        loginButton = driver.findElement(locators.getLocator("loginButton"));
    }

    public void login(String username, String password) {

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);

        loginButton.click();
    }
}