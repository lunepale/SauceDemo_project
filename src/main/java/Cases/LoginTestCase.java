package Cases;

import Pages.CartPage;
import Pages.ProductPage;
import Steps.LoginSteps;
import org.openqa.selenium.WebDriver;

public class LoginTestCase {
   // private final WebDriver driver;
    private final LoginSteps loginSteps;
    private final ProductPage productPage;
    private final CartPage cartPage;

    public LoginTestCase( LoginSteps loginSteps, ProductPage productPage, CartPage cartPage) {
       // this.driver = driver;
        this.loginSteps = loginSteps;
        this.productPage = productPage;
        this.cartPage = cartPage;
    }

    public void execute() {
        // Ваши шаги тестового сценария
        loginSteps.performLogin("standard_user", "secret_sauce");

        // Дополнительные шаги для проверки наличия цены и кнопки "Add to Cart"
        assert productPage.isPriceDisplayed() : "Product price is not displayed.";
        assert productPage.isAddToCartButtonDisplayed() : "Add to Cart button is not displayed";

        // Добавление продукта в корзину
        productPage.addToCart();

        // Проверка содержимого корзины после добавления продукта
        assert cartPage.isCartItemDisplayed() : "Cart is empty.";
        assert cartPage.isProductInCart("Sauce Labs Backpack") : "Product not in cart.";
        assert cartPage.isProductPriceCorrect("Sauce Labs Backpack", "$29.99") : "Incorrect product price in cart.";

        // Добавьте дополнительные шаги или проверки
    }
}
