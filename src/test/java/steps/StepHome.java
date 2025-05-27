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
    driver = new ChromeDriver();
    driver.get("https://automationexercise.com/");
    driver.manage().window().maximize();
    }

@Then("La url debe ser {string}")

    public void laUrlDebeSer(String expectedUrl){
    String actualUrl = driver.getCurrentUrl();

    System.out.println("URL Actual: " + actualUrl);
    System.out.println("URL Esperada: " + expectedUrl);

    Assert.assertEquals(expectedUrl, actualUrl);
}


@And("El usuario cierra la pagina")

public void cierre(){
    if (driver != null) {
        driver.quit();
}


}
}