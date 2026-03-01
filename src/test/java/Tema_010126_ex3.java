import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class Tema_010126_ex3 {

        WebDriver driver;
        //Ex 3
        @Test
        public void dryOpenClosedA(){
            driver = new ChromeDriver();
            driver.get("https://www.example.com");
            System.out.println("dryOpenClosedA() ran!");
        }

        @Test
        public void dryOpenClosedB(){
            driver = new ChromeDriver();
            driver.get("https://www.apple.com");
            System.out.println("dryOpenClosedB() ran!");
        }

        @AfterMethod
        public void closeTab(){
            driver.quit();
        }

}
