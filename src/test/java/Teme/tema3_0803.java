package Teme;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class tema3_0803 {
    WebDriver driver = new ChromeDriver();


    @BeforeMethod
    public void openCodeAcademyWebPage() {
        driver.get("https://demoqa.com/automation-practice-form");

    }

    //a.Gaseste campul First Name folosind Xpath, bazat pe placeholder
    @Test
    public void filds() {
        WebElement firstName = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
        // b.Introdu in acel camp valoarea “Test”
        firstName.sendKeys("Test");
        //c.Gaseste campul Last Name folosing XPath bazat pe atributul id
        WebElement lastName = driver.findElement(By.xpath("//input[@id='lastName']"));
        //d.Introdu valoarea “User”
        lastName.sendKeys("User");
        //e.Gaseste campul Email folosing XPath bazat pe atributul id
        //WebElement email = driver.findElement(By.xpath("//input[@id='userEmail']"));
        WebElement email = driver.findElement(By.id("userEmail"));
        //f.Introdu textul “test@email.com”
        email.sendKeys("test@email.com");
        //g.Apasa oricare din butoanele radio de la Gender
        WebElement Female = driver.findElement(By.xpath("//input[@id='gender-radio-2']"));
        Female.click();

        //h.Introdu un numar de telefon in campul pentru Mobile
        WebElement mobil = driver.findElement(By.xpath("//input[@placeholder='Mobile Number']"));
        mobil.sendKeys("1234567890");

        //i.Introdu un text in campul pentru ‘Subjects’

        WebElement subject = driver.findElement(By.id("subjectsInput"));
        //subject.sendKeys("Asa deci");
        subject.sendKeys("English");
        subject.sendKeys(Keys.ENTER);


        //j.Introdu un text in campul pentru ‘Current Address’
        WebElement address = driver.findElement(By.id("currentAddress"));
        address.sendKeys("Sfantu Gheorghe");

        //k.Gaseste butonul Submit dupa text si apasa folosind click
        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();

        //l.BONUS optional: verifica aparitia pop-up-ului de confirmare si apasa pe butonul Close
        //WebElement buttonClose = driver.findElement(By.xpath("//button[text()='Close']"));
        WebElement buttonClose = driver.findElement(By.id("closeLargeModal"));
        System.out.println("Butonul este: " + buttonClose);
        //buttonClose.click();--> nu merge butonul in sine, comanda e buna

    }
}

   /* @AfterMethod
    public void tearDown() {
        driver.quit();
    }*/








