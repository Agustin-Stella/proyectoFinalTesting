package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class StepHome {
    private WebDriver driver;



@Given("El usuario abre la pagina principal")
    public void ElUsuarioAbreLaPaginaPrincipal(){
    driver = Hooks.driver;
    driver.get("https://automationexercise.com");
    driver.manage().window().maximize();
    }


    @Then("La url debe ser {string}")
    public void laUrlDebeSer(String urlEsperada) {
        String urlActual = driver.getCurrentUrl();


        String actual = urlActual.endsWith("/") ? urlActual.substring(0, urlActual.length() - 1) : urlActual;
        String esperada = urlEsperada.endsWith("/") ? urlEsperada.substring(0, urlEsperada.length() - 1) : urlEsperada;

        Assert.assertEquals(esperada, actual);
    }


@And("El usuario cierra la pagina")

public void cierre(){
    if (driver != null) {
        driver.quit();
}


}
}