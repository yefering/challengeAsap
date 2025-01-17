package com.qaautomation.stepdefinitions;

import com.qaautomation.pages.BlazePage.BlazeHomePage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LoginblazeSteps {
    private BlazeHomePage blazeHomePage;
    private WebDriver driver;

    @Given("el usuario se encuentra en al home")
    public void elUsuarioSeEncuentraEnAlHome() {
        blazeHomePage = BlazeHomePage.getBlazeHome();

    }

    @After("@logingBlazeOk")
    public void tearDown() {
        blazeHomePage.teardown();
    }

    @When("el usuario hace clic en el boton {string}")
    public void elUsuarioHaceClicEnElBoton(String nameBtn) {
        blazeHomePage.clickBtn(nameBtn);
    }

    @And("el usuario ingresa {string} en el campo {string}")
    public void elUsuarioIngresaEnElCampo(String inputTxt, String nomImput) {
        blazeHomePage.ingresaDatoCampo(nomImput, inputTxt);
    }

    @Then("el usuario visualiza {string}")
    public void elUsuarioVisualiza(String txtBuscar) {
        String userLogin = blazeHomePage.getUsuarioLogeado();
        Assert.assertTrue("[WARNING] El usuario no logeo", userLogin.contains(txtBuscar));
    }

    @Then("el usuario visualiza el Popup con el mensaje {string}")
    public void elUsuarioVisualizaElPopupConElMensaje(String mensaje) {
        String msj = blazeHomePage.popUpAlert();
        Assert.assertTrue("[WARNING] No es el mensaje esperado ", mensaje.equalsIgnoreCase(msj));

    }
}
