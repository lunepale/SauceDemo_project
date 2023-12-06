package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage {
    private final WebDriver driver;
    private final PageLocators locators;
    private WebElement productPrice;
    private WebElement addToCartButton;

    public ProductPage(WebDriver driver, PageLocators locators) {
        this.driver = driver;
        this.locators = locators;
    }

    public void initElements() {
        productPrice = driver.findElement(locators.getLocator("productPrice"));
        addToCartButton = driver.findElement(locators.getLocator("addToCartButton"));
    }

    public boolean isPriceDisplayed() {

        return productPrice.isDisplayed();
    }

    public boolean isAddToCartButtonDisplayed() {

        return addToCartButton.isDisplayed();
    }

    public void addToCart() {

        addToCartButton.click();
    }
}