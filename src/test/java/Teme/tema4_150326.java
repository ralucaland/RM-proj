package Teme;




import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.util.List;

public class tema4_150326 {
    WebDriver driver = new ChromeDriver();

    @Test
    public void open()throws InterruptedException{
        driver.get("https://practicesoftwaretesting.com/");

        // verificare titlu
        String actualTitle = driver.getTitle();
        String expectedTitle = "Practice Software Testing - Toolshop - v5.0";

        Assert.assertEquals(actualTitle, expectedTitle);

        //Verifică dacă logo-ul aplicației este vizibil.
        WebElement logo = driver.findElement(By.tagName("svg"));
        Assert.assertTrue(logo.isDisplayed());

        //2.Creează un test pentru căutarea unui produs
        //a.Identifică search bar.
        WebElement searchBar = driver.findElement(By.cssSelector("input[data-test='search-query']"));

        //b.Introdu textu “hammer”
        searchBar.sendKeys("hammer");
        //d.Așteaptă afișarea rezultatelor.
        Thread.sleep(3000);

        //c.Apasă Enter sau butonul de căutare.
        searchBar.sendKeys(Keys.ENTER);

        //e.Verifică dacă apare cel puțin un produs în listă.
        List<WebElement> products = driver.findElements(By.cssSelector(".card"));
        Assert.assertTrue(products.size() > 0);
        Thread.sleep(3000);

        //3.Creează un test pentru deschiderea unui produs
        //Deschide pagina principală.
        //driver.navigate().back();-->exista alta metoda?
        driver.get("https://practicesoftwaretesting.com/");
        //Așteaptă încărcarea produselor.
        Thread.sleep(3000);
        //c.Apasă pe primul produs din listă.
        WebElement firstProduct = driver.findElement(By.className("card-title"));
        firstProduct.click();
        //d.Verifică dacă:
        Thread.sleep(3000);
        //**imaginea produsului este vizibilă
        WebElement productImage = driver.findElement(By.className("figure-img"));
        Assert.assertTrue(productImage.isDisplayed());
        //*butonul Add to cart este vizibil.
        WebElement addToCartButton = driver.findElement(By.id("btn-add-to-cart"));
        Assert.assertTrue(addToCartButton.isDisplayed());
        Thread.sleep(3000);


        //  4.Creează un test pentru filtrarea produselor
        //a.Deschide pagina principală.

        driver.get("https://practicesoftwaretesting.com/");
        //c.Așteaptă actualizarea listei.
        Thread.sleep(3000);
        //b.Selectează un filtru (ex: brand sau categorie)

        driver.findElement(By.xpath("//label[contains(.,'MightyCraft')]")).click();

        //d.Verifică dacă produsele afișate respectă filtrul.
        List<WebElement> products2 = driver.findElements(By.className("card-title"));
        Assert.assertTrue(products2.size() > 0);
    }
}
