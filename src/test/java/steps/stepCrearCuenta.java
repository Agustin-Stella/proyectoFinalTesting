package steps;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class stepCrearCuenta {
    private WebDriver driver;


    @Given("El usuario esta en la pagina de registro")
    public void elUsuarioEstaEnLaPaginaDeRegistro(){
        driver = Hooks.driver;
        driver.get("https://automationexercise.com/login");
        driver.manage().window().maximize();

    }

    @When("Ingresa nombre e gmail y aprieta sign up")
    public void ingresaNombreEGmailYAprietaSignUp(){

        WebElement nombre = driver.findElement(By.xpath("//input[@name='name']"));
        nombre.sendKeys("Agustin");


        WebElement gmail = driver.findElement(By.xpath("//div[@class='signup-form']//input[@name='email']"));
        gmail.sendKeys("agustin6377@gmail.com");

        WebElement signUp= driver.findElement(By.xpath("//button[.='Signup']"));
        signUp.click();
    }

@Then("Rellena todos los campos con su informacion")
    public void rellenaTodosLosCamposConSuInformacion(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement title = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Mr']")));
        title.click();

        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        password.sendKeys("agustin12345Ag");



    WebElement dia = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='days']")));
        Select seleccionarDia = new Select(dia);
        seleccionarDia.selectByVisibleText("11");

        WebElement mes = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='months']")));
        Select seleccionarMes = new Select(mes);
        seleccionarMes.selectByVisibleText("October");

        WebElement year = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='years']")));
        Select seleccionaryear = new Select(year);
        seleccionaryear.selectByVisibleText("2003");

        WebElement nombre = driver.findElement(By.xpath("//input[@id='first_name']"));
        nombre.sendKeys("Agustin");

        WebElement apellido = driver.findElement(By.xpath("//input[@id='last_name']"));
        apellido.sendKeys("Lopez");

        WebElement company= driver.findElement(By.xpath("//input[@id='company']"));
        company.sendKeys("compañia");

        WebElement adress = driver.findElement(By.xpath("//p[4]/input[@class='form-control']"));
        adress.sendKeys("direccion");

        WebElement pais = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='country']")));
        Select seleccionarpais = new Select(pais);
        seleccionarpais.selectByVisibleText("Canada");

        WebElement estado =driver.findElement(By.xpath("//input[@id='state']"));
        estado.sendKeys("Terranova");

        WebElement ciudad =driver.findElement(By.xpath("//input[@id='city']"));
        ciudad.sendKeys("Gander");

        WebElement zipCode=driver.findElement(By.xpath("//input[@id='zipcode']"));
        zipCode.sendKeys("1111");

        WebElement numero = driver.findElement(By.xpath("//input[@id='mobile_number']"));
        numero.sendKeys("1112223344");


}

@And("Click en create Acount y verifica si se creo correctamente")

public void cliclEnCreateAcountYVerificaSiSeCreoCorrectamente(){
        WebElement createAcount = driver.findElement(By.xpath("//button[.='Create Account']"));
        createAcount.click();


        try {WebElement verificar = driver.findElement(By.xpath("//*[@id=\'form\']/div/div/div"));
        Assert.assertTrue(verificar.isDisplayed(), "La cuenta no se creo correctamente");
    } catch (NoSuchElementException e) {
        Assert.fail("Error al encontrar el div");
    }

}

@And("Cierre de pagina")
    public void cierreDePagina(){
    if (driver != null) {
        driver.quit();

}


}
}