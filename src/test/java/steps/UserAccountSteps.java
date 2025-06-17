package steps;

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

public class UserAccountSteps {
    private WebDriver driver;

    @Given("El usuario esta en la pagina de login")
    public void elUsuarioEstaEnLaPaginaDeLogin() {
        driver = Hooks.driver;
        driver.get("https://automationexercise.com/login");
        driver.manage().window().maximize();
    }

    @When("Rellena los campos gmail y password")
    public void rellenaLosCamposGmailYPassword() {
        WebElement email = driver.findElement(By.xpath("//div[contains(@class, 'login-form')]//input[@name='email']"));
        email.sendKeys("agustin6377@gmail.com");

        WebElement password = driver.findElement(By.xpath("//div[contains(@class, 'login-form')]//input[@name='password']"));
        password.sendKeys("agustin12345Ag");
    }

    @And("Click en Login y verifica si se logueo correctamente")
    public void clickEnLoginYVerificaSiSeLogueoCorrectamente() {
        WebElement login = driver.findElement(By.xpath("//button[.='Login']"));
        login.click();

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement logout = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(.,'Logout')]")));
            Assert.assertTrue(logout.isDisplayed(), "El botón de Logout no está en la página.");
        } catch (NoSuchElementException e) {
            Assert.fail("Error al iniciar sesión: " + e.getMessage());
        }
    }

    @Then("Click en eliminar cuenta")
    public void clickEnEliminarCuenta() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement deleteAccount = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(.,'Delete Account')]")));
        deleteAccount.click();
    }

    @And("Verifica si se elimino correctamente")
    public void verificaSiSeEliminoCorrectamente() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement texto = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[.='Account Deleted!']")));
            Assert.assertTrue(texto.isDisplayed(), "El mensaje de cuenta eliminada no está presente.");
        } catch (Exception e) {
            Assert.fail("Prueba fallida: el mensaje no se encontró. Error: " + e.getMessage());
        }
    }

    @And("El usuario cierra la página")
    public void cierreDeLaPagina() {
        if (driver != null) {
            driver.quit();
            System.out.println("Navegador cerrado.");
        } else {
            System.out.println("Driver es null, no se pudo cerrar.");
        }

    }
}