package com.nttdata.steps;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static io.restassured.RestAssured.given;
import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;

import static io.restassured.RestAssured.given;

public class Crear_consulta_order {

    private static String CREATE_ORDER = "https://petstore.swagger.io/v2/store/order";

    @Step("Crear_consulta_order {0} en PetStore")
    public void crearOrder(int petId, int quantity){
        SerenityRest.given()
                .contentType("application/json")
                .relaxedHTTPSValidation()
                .body("{\n" +
                        "  \"id\": 0,\n" +
                        "  \"petId\": "+ petId +",\n" +
                        "  \"quantity\": "+ quantity +",\n" +
                        "  \"shipDate\": \"2024-08-21T16:21:14.149Z\",\n" +
                        "  \"status\": \"placed\",\n" +
                        "  \"complete\": true\n" +
                        "}")
                .log().all()
                .post(CREATE_ORDER)
                .then()
                .log().all()
        ;

    }
    public void validarstatus(String status) {
        restAssuredThat(response -> response.body("'status'", equalTo(status)));
    }

    public void validarCodigoRespuesta(int statusCode) {
        restAssuredThat(response -> response.statusCode(statusCode));


    }


    public boolean crearConsultaorder(boolean expectedValue) {
        // Obtener el valor de "complete" desde la última respuesta de la API
        boolean actualValue = SerenityRest.lastResponse().jsonPath().getBoolean("complete");

        // Comparar el valor actual con el valor esperado y devolver el resultado
        return actualValue == expectedValue;
    }

    private static String URL = null;
    private Response response;

    public void definirurl(String url){
        URL = url;
    };

    public void consultaOrder() {

        response =
                given()
                        .contentType("application/json")
                        .log()
                        .all()
                        .get(URL+"/57285312")
        ;
    };

}

