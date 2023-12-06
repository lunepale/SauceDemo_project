package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
    private final WebDriver driver;
    private final PageLocators locators;
    private WebElement cartItem;
    private WebElement cartItemName;
    private WebElement cartItemPrice;

    public CartPage(WebDriver driver, PageLocators locators) {
        this.driver = driver;
        this.locators = locators;
    }

    public void initElements() {
        cartItem = driver.findElement(locators.getLocator("cartItem"));
        cartItemName = driver.findElement(locators.getLocator("cartItemName"));
        cartItemPrice = driver.findElement(locators.getLocator("cartItemPrice"));
    }

    public boolean isCartItemDisplayed() {
        return  cartItem.isDisplayed();
    }

    public boolean isProductInCart(String productName) {
        return cartItemName.getText().equals(productName);
    }

    public boolean isProductPriceCorrect(String productName, String expectedPrice) {
        if (isProductInCart(productName)) {
            String actualPrice = cartItemPrice.getText().trim();
            return actualPrice.equals(expectedPrice);
        } else {

            return false;
        }
    }
}