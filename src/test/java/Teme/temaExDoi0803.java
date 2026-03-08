package Teme;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class temaExDoi0803 {
//2.Creaza un test, pornind de la URL-ul https://demoqa.com/webtables
WebDriver driver2 = new ChromeDriver();

@BeforeMethod
  public void openDrive2() {
        driver2.get("https://demoqa.com/webtables");
    }

//a.Da click pe butonul ‘Add’
    @Test
    public void ADD(){
        WebElement ADD =driver2.findElement(By.id("addNewRecordButton"));
        ADD.click();

        //b.Completeaza toate campurile din pop-up-ul care se deschide
        WebElement first =driver2.findElement(By.id("firstName"));
        first.sendKeys("ABCD");
        WebElement last =driver2.findElement(By.id("lastName"));
        last.sendKeys("GHIJ");
        WebElement email =driver2.findElement(By.id("userEmail"));
        email.sendKeys("user@email.com");
        WebElement age =driver2.findElement(By.id("age"));
        age.sendKeys("39");
        WebElement Salary =driver2.findElement(By.id("salary"));
        Salary.sendKeys("18000");

        WebElement department =driver2.findElement(By.id("department"));
        department.sendKeys("it");

        //c.Da click pe butonul Submit
        WebElement submit = driver2.findElement(By.id("submit"));
        submit.click();
    }
}





