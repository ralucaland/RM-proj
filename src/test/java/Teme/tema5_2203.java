package Teme;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class tema5_2203 {
    WebDriver driver = new ChromeDriver();

    @Test
    public void open() {
        driver.get("https://practicesoftwaretesting.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // Selectează categoria Drill
        WebElement drillCategory = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//label[contains(normalize-space(.), 'Drill')]"))
        );
        drillCategory.click();

         //Selectează brand ForgeFlex + mightyCraft(stabil, pe text)
        WebElement forgeFlex = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//label[contains(normalize-space(.), 'ForgeFlex')]"))
        );
        forgeFlex.click();

        WebElement mightyCraft = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//label[contains(normalize-space(.), 'MightyCraft')]"))
        );
        mightyCraft.click();

        // Așteaptă actualizarea produselor
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("card-title"))
        );

        // d.Verifică faptul că cel puțin două produse conțin numele categoriei selectate.

        List<WebElement> products = driver.findElements(By.className("card-title"));

        int count = 0;

        for (WebElement product : products) {
            String text = product.getText();

            if (text.contains("Drill")) {
                count++;
            }
        }
        System.out.println("Numar produse care contin 'Drill': " + count);
    }
}










