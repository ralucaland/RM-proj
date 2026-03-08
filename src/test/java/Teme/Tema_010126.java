package Teme;/*
1.Deschide un site -> deschide browser, navigheaza catre un URL (la alegere), inchide browserul
2.Verifica titlul paginii -> deschide URL-ul (la alegere, sau https://example.com/), ia titlul paginii, verifica cu Assert titlul
a.Hint: getTitle(), Assert.assertTrue
3.Creaza o clasa care are doua teste: unul care navigheaza la https://example.com/ si inchide browserul;
unul care navigheaza la https://www.apple.com/ si inchide browserul.
4.Refactorizeaza clasa de la exercitiul 3 sa foloseasca @BeforeMethod si @AfterMethod
5.Creaza un test prin care se navigheaza la https://example.com si verifica:
a.Titlul nu este null
b.Titlul consinte ‘Example’

*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

//1.Deschide un site -> deschide browser, navigheaza catre un URL (la alegere), inchide browserul

public class Tema_010126 {

    WebDriver driver = new ChromeDriver();
    int testNo = 0;

    @BeforeMethod
        public void openCodeAcademyWebPage() {
            driver.get("https://www.codeacademy.com");
        }

//2. Verifica titlul paginii -> deschide URL-ul (la alegere, sau https://example.com/),
// ia titlul paginii, verifica cu Assert titlul
// a.Hint: getTitle(), Assert.assertTrue
//
        @Test
        public void clickOnCodeFoundation(){
            //driver.findElement(By.cssSelector("a[href='/catalog/subject/code-foundations']")).click();
            // driver.findElement(By.xpath("//span[normalize-space()='Code foundations']")).click();
            driver.findElement(By.linkText("Code foundations")).click();
            System.out.println("Test1 Passed: element was clicked!");
       }

        @Test
        public void verifyTitle(){
            String titleToVerify = driver.getTitle();
            String expectedTitle = "Learn to Code - for Free | Codecademy";
            System.out.println(titleToVerify);
            Assert.assertTrue(
                    titleToVerify.equals(expectedTitle), "Title mismatch!"
            );
            System.out.println("Test2 Passed: Title match!");
        }

        //3.Creaza o clasa care are doua teste: unul care navigheaza la https://example.com/ si inchide browserul;
        //unul care navigheaza la https://www.apple.com/ si inchide browserul.

    @AfterMethod
    public void runAfterEachTest() {
        testNo++;
        System.out.println("The test no." + testNo +" ran!!!");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        System.out.println("driver quit -> Page CLOSED!");
    }
}