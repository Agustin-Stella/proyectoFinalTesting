package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class stepLogin {
    private WebDriver driver;

    @Given("El usuario esta en la pagina de login")
    public void elUsuarioEsraEnLaPaginaDeLogin(){
    driver = new ChromeDriver();
    driver.get("https://automationexercise.com/login");
    driver.manage().window().maximize();

    }

    @When("Rellena los campos gmail y contraseña")
    public void rellenaLosCamposGmailYContraseña(){

        WebElement email = driver.findElement(By.xpath("//div[contains(@class, 'login-form')]//input[@name='email']"));
        email.sendKeys("agustin78827@gmail.com");

        WebElement contraseña= driver.findElement(By.xpath("//div[contains(@class, 'login-form')]//input[@name='password']"));
        contraseña.sendKeys("agustin12345Ag");


    }
    @And("Click en Login")
    public void clickEnLogin(){

        WebElement login = driver.findElement(By.xpath("//button[.='Login']"));
        login.click();

    }

    @And("Cierre de la pagina")
    public void cierreDeLaPagina(){
        if (driver != null) {
            driver.quit();

        }

}}
