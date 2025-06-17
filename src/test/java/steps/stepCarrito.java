package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class stepCarrito {
private WebDriver driver;

@Given("El usuario esta en la pagina de productos")
    public void elUsuarioEstaEnLaPaginaDeProductos(){
    driver = Hooks.driver;
    driver.get("https://automationexercise.com");
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

    @Then("Abrimos el carro y el producto debe estar en el")
    public void abrimosElCarroYElProductoDebeEstarEnEl(){

    WebElement carro = driver.findElement(By.xpath("//ul[@class='nav navbar-nav']//a[contains(.,'Cart')]"));
    carro.click();


        try { WebElement productoEnCarro= driver.findElement(By.xpath("//a[.='Blue Top']"));
            Assert.assertTrue(productoEnCarro.isDisplayed(), "El producto 'Blue Top' no está en el carro.");
        } catch (NoSuchElementException e) {
            Assert.fail("El producto 'Blue Top' no está presente en la página.");
        }

    }



    @And("Cerrar pagina")
    public void cerrarPagina(){
        if (driver != null) {
            driver.quit();

        }


    }
}
