package Teme.tema9.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BasePage {

    // Constructor
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    // Locatori
    private By productName = By.xpath("//h1[@data-test='product-name']");
    private By productPrice = By.xpath("//span[@data-test='unit-price']");
    private By addToCartButton = By.xpath("//button[@data-test='add-to-cart']");
    private By cartQuantity = By.cssSelector("[data-test='cart-quantity']");

    // Metodă pentru numele produsului
    public String getProductName() {
        return getText(productName);
    }

    // Metodă pentru prețul produsului
    public String getProductPrice() {
        return getText(productPrice);
    }

    // Metodă pentru adăugare în coș
    public void addToCart() {
        click(addToCartButton);
    }

        public void waitForCartUpdate(){
            wait.until(ExpectedConditions.textToBe(cartQuantity, "1"));
        }
    }

