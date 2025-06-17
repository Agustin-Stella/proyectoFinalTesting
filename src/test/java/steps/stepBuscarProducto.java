package steps;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class stepBuscarProducto {
    private WebDriver driver;

    @Given("El usuario se posiciona en la pagina de productos")
    public void elUsuarioSePosicionaEnLaPaginaDeProductos(){

        driver = Hooks.driver;
        driver.get("https://automationexercise.com/products");
        driver.manage().window().maximize();
    }

    @Then("Ingresa el nombre del producto en la barra de busqueda")
    public void ingresaElNombreDelProductoEnLaBarraDeBusqueda(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search_product")));
        WebElement buscar =driver.findElement(By.xpath("//input[@id='search_product']"));
        buscar.sendKeys("Blue Top");

    }

    @When("Hace click en la lupa")
    public void haceClickEnLaLupa(){

        WebElement lupa = driver.findElement(By.xpath("//i[@class='fa fa-search']"));
        lupa.click();


    }

    @And("El producto Blue Top aparece")
    public void elProductoBlueTopAparece(){


        try {WebElement producto = driver.findElement(By.xpath("//p[contains(text(), 'Blue Top')]"));
            Assert.assertTrue(producto.isDisplayed(), "El producto 'Blue Top' no está visible.");
        } catch (NoSuchElementException e) {
            Assert.fail("El producto 'Blue Top' no está presente en la página.");
        }


    }

    @And("Cerrar pagina web")
    public void cerrarPaginaWeb(){

        if (driver != null) {
            driver.quit();

        }
    }
}
