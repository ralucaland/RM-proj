package Teme;/*3.Creaza o clasa care are doua teste: unul care navigheaza la https://example.com/ si inchide browserul;
unul care navigheaza la https://www.apple.com/ si inchide browserul.
3.Creaza o clasa care are doua teste: unul care navigheaza la https://example.com/ si inchide browserul;
unul care navigheaza la https://www.apple.com/ si inchide browserul.
4.Refactorizeaza clasa de la exercitiul 3 sa foloseasca @BeforeMethod si @AfterMethod
5.Creaza un test prin care se navigheaza la https://example.com si verifica:
a.Titlul nu este null
b.Titlul consinte ‘Example’
*/

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Tema_010126_ex4 {

    WebDriver driver = new ChromeDriver();
    WebDriver driverSecond = new ChromeDriver();


    //Ex 3
    public void dryOpenClosed(){
        driver.get("https://www.example.com");
        driver.quit();
        driverSecond.get("https://www.apple.com");
        driverSecond.quit();
        System.out.println("dryOpenClosed() ran!");
    }

    //Ex 4
    @BeforeMethod
    public void setUp(){
        driver.get("https://www.example.com");
        driverSecond.get("https://www.apple.com");
        System.out.println("setUp() ran!");
    }

    /*
    5.Creaza un test prin care se navigheaza la https://example.com si verifica:
    a.Titlul nu este null
    b.Titlul consinte ‘Example’
    */
    @Test
    public void VerifyTitle(){
        String titleToVerify = driver.getTitle();
        //String titleToVerify = null;
        String expectedTitle = "Example Domain";
        System.out.println("The title of the page is :"+titleToVerify);
        Assert.assertFalse(
                (titleToVerify == null), "Title is null!"
        );
        Assert.assertTrue(
                titleToVerify.equals(expectedTitle), "Title mismatch!"
        );
        System.out.println("Test2 Passed: Title match!");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
        driverSecond.quit();
    }


}