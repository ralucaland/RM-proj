package Teme.tema9.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private By cartIcon = By.cssSelector("a[href='/checkout']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void openCartPage() {
        click(cartIcon);
    }
    public boolean isProductInCart(String productName){
        By productInCart = By.xpath("//*[contains(normalize-space(),'" + productName + "')]");
        return isDisplayed(productInCart);
    }
}

