package Teme.tema6;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class Tema6_ex1si2_2903 {

    WebDriver driver;
    WebDriverWait wait;
    String firstTab;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().window().maximize();

        // 1. Deschide primul site
        driver.get("https://www.codecademy.com");

        // salvăm primul tab
        firstTab = driver.getWindowHandle();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void clickCodeFundation() {

        // tabul 1 este deja deschis din @BeforeMethod -> Codecademy
        System.out.println("Tab 1: " + driver.getTitle());

        // deschide un tab nou
        driver.switchTo().newWindow(WindowType.TAB);

        // în tabul 2 deschide W3Schools
        driver.get("https://www.w3schools.com/java/#gsc.tab=0");

        // afișează titlul tabului 2
        System.out.println("Tab 2: " + driver.getTitle());

        // revine pe tabul principal
        driver.switchTo().window(firstTab);

        // afișează din nou titlul tabului 1
        System.out.println("Back to Tab 1: " + driver.getTitle());
    }

    //2. Creează un test care:

    @Test
    public void test2 () {
        //deschide 2 taburi-->primul e in @befor
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.w3schools.com/java/#gsc.tab=0");

        Set<String> tabs = driver.getWindowHandles();

        String tab1 = "";
        String tab2 = "";
        for (String tab : tabs) {
            driver.switchTo().window(tab);
            String title = driver.getTitle();

            if (title.contains("Codecademy")) {
                tab1 = tab;
            } else if (title.contains("Java")) {
                tab2 = tab;
            }
        }
        //Verifică titlul fiecărui tab folosind Assert*/
        driver.switchTo().window(tab1);
        Assert.assertTrue(driver.getTitle().contains("Codecademy"));

        driver.switchTo().window(tab2);
        Assert.assertTrue(driver.getTitle().contains("Java"));
}
    @Test
    public void test3(){
        //deschide 2 taburi
        //deschide 2 taburi-->primul e in @befor
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.w3schools.com/java/#gsc.tab=0");

// închide unul cu driver.close()
//revine pe tabul principal
// Verifică dacă încă ești pe pagina corectă
//Ruleaza testul folosing fisier .xml*/
    }
}


/*

4. Creează un test care:
            1.Deschide https://practicesoftwaretesting.com/
            2.Navighează pe o categorie
3.Deschide produsul într-un tab nou
4.Revine în tabul principal
5.Face refresh
6.Adauga:
    a.@BeforeMethod
            b.@AfterMethod
            c.Assert
7.Ruleaza testul folosind un fisier .xml*/