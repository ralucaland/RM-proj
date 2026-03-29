package Teme;


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

public class Tema6_2903 {

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

        // 1. Găsește și dă click pe link-ul "Code Foundations"
        driver.findElement(By.cssSelector("a[href='/catalog/subject/code-foundations']")).click();

        // 2. Deschide un TAB nou și face automat switch pe el
        driver.switchTo().newWindow(WindowType.TAB);

        // 3. Accesează site-ul W3Schools în tab-ul nou
        driver.get("https://www.w3schools.com/java/#gsc.tab=0");

        // 3b.Accept pop-up (iframe)
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("fast-cmp-iframe")));

        // 3c. Click  pe butonul Accept
        driver.findElement(By.xpath("//button[text()='Accept']")).click();

        // 3d. Revine la pagina principală (iese din iframe)
        driver.switchTo().defaultContent();
        //4.afișează titlul ambelor taburi
        System.out.println("Tab 2: " + driver.getTitle());

        // revine în tabul 1
        driver.switchTo().window(firstTab);

        // tabul 1
        System.out.println("Tab 1: " + driver.getTitle());
          }
    //2. Creează un test care:

    @Test
    public void test2 () {
        //deschide 2 taburi
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.w3schools.com/java/#gsc.tab=0");

        // aici e momentul corect
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
}




/*
3. Creează un test care:
            ●deschide 2 taburi
●închide unul cu driver.close()
●revine pe tabul principal
● Verifică dacă încă ești pe pagina corectă
●Ruleaza testul folosing fisier .xml
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