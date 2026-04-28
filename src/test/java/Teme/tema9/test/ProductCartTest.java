package Teme.tema9.test;


import Teme.tema9.pages.CartPage;
import Teme.tema9.pages.HomePage;
import Teme.tema9.pages.ProductPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ProductCartTest {

    WebDriver driver;
    HomePage homePage;
    ProductPage productPage;
    CartPage cartPage;


    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();   // deschide browserul
        driver.manage().window().maximize();

        homePage = new HomePage(driver);  // trimite driverul în HomePage
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        CartPage cartPage;
    }

    @Test
    public void selectProductTest() {

        // 1. Deschide aplicația
        homePage.openApplication();

        // 2. Selectează produs
        homePage.clickOnProduct("Claw Hammer with Shock Reduction Grip");

        //3 Scoate numele produsului din pagina de detalii
        String name = productPage.getProductName();
        System.out.println(name);

        //4 Scoate pretul produsului din pagina de detalii si verifica
        String price = productPage.getProductPrice();
        Assert.assertEquals(name, "Claw Hammer with Shock Reduction Grip");
        System.out.println(price);

        //5. Adauga produsul in cos
        productPage.addToCart();
        productPage.waitForCartUpdate();

        //6 dechide cosul
        cartPage.openCartPage();
        //7 verifica ca produsl e in cos
        boolean isPresent = cartPage.isProductInCart(name);

        Assert.assertTrue(isPresent);
    }
    @Test
    public void verifyProductDetailsTest() {

        homePage.openApplication();
        homePage.clickOnProduct("Claw Hammer with Shock Reduction Grip");

        String name = productPage.getProductName();
        String priceText = productPage.getProductPrice();

        // verificare nume
        Assert.assertFalse(name.isEmpty());

        // verificare preț > 0
        double price = Double.parseDouble(priceText.replace("$", ""));
        Assert.assertTrue(price > 0);
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();  // închide browserul
    }
}
