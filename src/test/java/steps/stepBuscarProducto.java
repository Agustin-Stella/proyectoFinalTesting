package steps;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class stepBuscarProducto {
    private WebDriver driver;

    @Given("El usuario se posiciona en la pagina de productos")
    public void elUsuarioSePosicionaEnLaPaginaDeProductos(){

        driver = new ChromeDriver();
        driver.get("https://automationexercise.com/products");
        driver.manage().window().maximize();

    }

    @Then("Ingresa el nombre del producto en la barra de busqueda")
    public void ingresaElNombreDelProductoEnLaBarraDeBusqueda(){

        WebElement buscar =driver.findElement(By.xpath("//input[@id='search_product']"));
        buscar.sendKeys("Blue Top");

    }

    @When("Hace click en la lupa")
    public void haceClickEnLaLupa(){

        WebElement lupa = driver.findElement(By.xpath("//i[@class='fa fa-search']"));
        lupa.click();


    }

    @And("Cerrar pagina web")
    public void cerrarPaginaWeb(){

        if (driver != null) {
            driver.quit();

        }
    }
}
