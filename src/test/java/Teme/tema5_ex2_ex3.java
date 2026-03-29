package Teme;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class tema5_ex2_ex3 {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        //driver.quit();
    }

    @Test
    public void openProductAddToCartAndVerifyBasket() {
        driver.get("https://practicesoftwaretesting.com/");

        // a. Deschide un produs
        WebElement productTitleHome = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("(//a[contains(@href,'/product/')])[1]")
                )
        );
        productTitleHome.click();

        WebElement productNameElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("[data-test='product-name']")
                )
        );

        String productName = productNameElement.getText().trim();
        System.out.println("Selected product: " + productName);

        // b. Apasă Add to cart
        WebElement addToCartButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector("[data-test='add-to-cart']")
                )
        );
        addToCartButton.click();

        // c. Deschide coșul
        WebElement cartButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector("[data-test='nav-cart']")
                )
        );
        cartButton.click();

        // d.i Verificare: produsul apare în coș
        WebElement productInCart = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("[data-test='product-title']")
                )
        );
        Assert.assertEquals(productInCart.getText().trim(), productName);

        // d.ii Verificare: cantitatea este 1
        WebElement quantityInput = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("[data-test='product-quantity']")
                )
        );
        Assert.assertEquals(quantityInput.getAttribute("value"), "1");
    }
    //a.Accesează site-ul.
    @Test
    public void SearchHammerAndAddToCart() {
        driver.get("https://practicesoftwaretesting.com/");

        // b. search
        WebElement searchInput = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("[data-test='search-query']")
                )
        );
        searchInput.sendKeys("Hammer");

        WebElement searchButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector("[data-test='search-submit']")
                )
        );
        searchButton.click();


        // c. deschide produsul Hammer
        WebElement hammerProduct = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//a[contains(@href,'/product/')][.//*[contains(text(),'Hammer')]]")
                )
        );
        hammerProduct.click();
        WebElement productNameElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("[data-test='product-name']")
                )
        );
        // d. Adaugă produsul în coș
        WebElement addToCartButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector("[data-test='add-to-cart']")
                )
        );
        addToCartButton.click();
        // e. Deschide coșul
        WebElement cartButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector("[data-test='nav-cart']")
                )
        );
        cartButton.click();

        //f.Verifică:
        WebElement productInCart = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("[data-test='product-title']")
                )
        );

        String cartProductName = productInCart.getText().trim();

        Assert.assertTrue(cartProductName.contains("Hammer"));
        //i.produsul este în coș
        //ii.cantitatea este 1
        WebElement quantityInput = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("[data-test='product-quantity']")
                )
        );

        Assert.assertEquals(quantityInput.getAttribute("value"), "1");
        //iii.prețul este afișat.
        WebElement priceElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("[data-test='product-price']")
                )
        );

        String price = priceElement.getText().trim();

        Assert.assertFalse(price.isEmpty());
    }
}




