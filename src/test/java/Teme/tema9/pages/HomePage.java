package Teme.tema9.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    // URL aplicație
    private String url = "https://practicesoftwaretesting.com/";

    // Constructor
    public HomePage(WebDriver driver) {
        super(driver);
    }

    // Deschide aplicația
    public void openApplication() {
        driver.get(url);
    }

    // Selectează produs după nume
    public void clickOnProduct(String productName) {

        By productLocator = By.xpath("//h5[@data-test='product-name' and contains(normalize-space(),'" + productName + "')]");
        //By productLocator = By.xpath("//a[@data-test='product-name' and contains(normalize-space(),'" + productName + "')]");
        //By productLocator = By.xpath("//h5[contains(text(),'" + productName + "')]");

        click(productLocator);

    }

}
