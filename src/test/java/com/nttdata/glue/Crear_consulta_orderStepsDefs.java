package com.nttdata.glue;

import com.nttdata.steps.Crear_consulta_order;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class Crear_consulta_orderStepsDefs {

    @Steps
    Crear_consulta_order crearConsultaorder;

    @When("creo la order con petId {int} y quantity {int}")
    public void creoLaOrderConPetIdYQuantity(int petId, int quantity) {
        crearConsultaorder.crearOrder(petId, quantity );
    }

    @Then("el código de respuesta es {int}")
    public void elCódigoDeRespuestaEs(int statusCode) {
       crearConsultaorder.validarCodigoRespuesta(statusCode);
    }


    @And("el status como {string}")
    public void elStatusComo(String status) {crearConsultaorder.validarstatus(status);
    }

    @And("complete es true")
    public void completeEsTrue() {
        Assert.assertTrue("el campo complete es false", crearConsultaorder.crearConsultaorder(true));
    }




    @Given("que tengo la url del servicio {string}")
    public void queTengoLaUrlDelServicio(String url) {crearConsultaorder.definirurl(url);
    }


    @When("hago la consulta de la order por orderId")
    public void hagoLaConsultaDeLaOrderPorOrderId() {
        crearConsultaorder.consultaOrder();
    }
}

