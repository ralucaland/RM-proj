package cursuri;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Curs0203 {

    /*@Test
    public void textsBoxTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        Actions actions = new Actions(driver);



       driver.get("https://demoqa.com/text-box");

        WebElement fullName = driver.findElement(By.id("userName"));
        WebElement email = driver.findElement(By.id("userEmail"));
        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));

        WebElement submit = driver.findElement(By.id("submit"));

        fullName.sendKeys("Ral");
        email.sendKeys("test@itschool.com");
        currentAddress.sendKeys("Timisoara");
        permanentAddress.sendKeys("Timis");

        actions.scrollToElement(submit).perform();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Scroll down by 500 pixels vertically
        //js.executeScript("window.scrollBy(0, 1500)");
        js.executeScript("arguments[0].scrollIntoView(false);", submit);

        submit.click();

        WebElement output = driver.findElement(By.id("output"));

        Assert.assertTrue(output.isDisplayed());
    }*/


        @Test
        public void buttons () {
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            Actions actions= new Actions(driver);

            driver.get("https://demoqa.com/buttons");
            WebElement doubleClick = driver.findElement(By.id("doubleClickBtn"));
            actions.doubleClick(doubleClick).perform();

            WebElement rightClick = driver.findElement(By.id("rightClickBtn"));
            actions.contextClick(rightClick).perform();

            WebElement clickMeDynamic = driver.findElement(By.xpath("//button[text()='Click Me']"));
            actions.click(clickMeDynamic).perform();
        }
    }