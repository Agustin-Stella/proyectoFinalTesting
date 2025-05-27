package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class stepCarrito {
private WebDriver driver;

@Given("El usuario esta en la pagina de productos")
    public void elUsuarioEstaEnLaPaginaDeProductos(){
    driver = new ChromeDriver();
    driver.get("https://automationexercise.com/products");
    driver.manage().window().maximize();
}

@When("Añadimos un producto al carrito")
    public void añadimosUnProductoAlCarrito(){

    try {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        WebElement producto = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='features_items']/div[2]")));


        Actions actions = new Actions(driver);
        actions.moveToElement(producto).perform();


        WebElement boton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='product-overlay']//a[contains(text(),'Add to cart')]")));


        boton.click();


    } catch (Exception e) {
        System.out.println("Error al agregar el producto al carrito: " + e.getMessage());
    }


   }
    @And("Click en continue")
    public void clickEnContinue(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement continueBoton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-success close-modal btn-block']")));
        continueBoton.click();
}
    @And("Cerrar pagina")
    public void cerrarPagina(){
        if (driver != null) {
            driver.quit();

        }


    }
}
