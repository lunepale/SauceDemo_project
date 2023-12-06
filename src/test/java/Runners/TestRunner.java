package Runners;

import Cases.LoginTestCase;
import Pages.CartPage;
import Pages.LoginPage;
import Pages.PageLocators;
import Pages.ProductPage;
import Steps.LoginSteps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestRunner {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver ();
        driver.get ("https://www.saucedemo.com/");
        PageLocators locators = new PageLocators("src/main/resources/LoginPage.def.csv");
        LoginPage loginPage = new LoginPage(driver, locators);
        ProductPage productPage = new ProductPage(driver, locators);
        CartPage cartPage = new CartPage (driver, locators);

        LoginSteps loginSteps = new LoginSteps(loginPage);
        LoginTestCase loginTestCase = new LoginTestCase (loginSteps, productPage, cartPage);


        loginPage.initElements();
        productPage.initElements();
        cartPage.initElements();


        loginTestCase.execute();

        driver.quit();
    }
}
