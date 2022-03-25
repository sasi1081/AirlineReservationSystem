package TestSteps;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

public class FlightStepDefs {




    @Given("A List of Flights")
    public void aListOfFlights() {
    }

    @And("I perform GETALL flight")
    public void iPerformGETALLFlight() {
        RestAssured.given()
                .then()
                .expect()
                .statusCode(200)
                .when()
                .get("http://localhost:8080/flights");

    }
    @Then("I Should see the list of flights")
    public void iShouldSeeTheListOfFlights() {
    }


    @And("I perform GET for one flight {string}")
    public void iPerformGETForOneFlight(String arg0) {
        RestAssured.given()
                .when()
                .get(String.format("http://localhost:8080/flights/%s",arg0))
                .then()
                .statusCode(200)
                .body("flightNo",equalTo("CP321"))
                .body("airlines",equalTo("CathayPacific"))
                .body("departureCity",equalTo("Tokyo"))
                .body("arrivalCity",equalTo("HongKong"))
                .body("dateOfDeparture",equalTo("26-3-2022")).log().all();
    }

    @Then("I Should see the flight")
    public void iShouldSeeTheFlight() {
    }

    @And("I perform POST operation")
    public void iPerformPOSTOperation() {

        JSONObject request = new JSONObject();
        request.put("flightNo","CP321");
        request.put("airlines","CathayPacific");
        request.put("departureCity","Tokyo");
        request.put("arrivalCity","HongKong");
        request.put("dateOfDeparture","26-3-2022");

        ValidatableResponse validatableResponse = given()
                .contentType(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                        .post("http://localhost:8080/flights/post")
                .then()
                .log()
                .all()
                .statusCode(200);


    }

    @And("I Perform UPDATE operation for flights")
    public void iPerformUPDATEOperationForFlights() {
        JSONObject request = new JSONObject();

        request.put("flightNo","CP321");
        request.put("airlines","CathayPacific");
        request.put("departureCity","Tokyo");
        request.put("arrivalCity","HongKong");
        request.put("dateOfDeparture","27-3-2022");


        ValidatableResponse validatableResponse = given()
                .contentType(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .put("http://localhost:8080/flights/update/CP321")
                .then()
                .statusCode(200);


    }

    @And("I Perform DELETE operation for flights")
    public void iPerformDELETEOperationForFlights() {
        ValidatableResponse validatableResponse = given()
                .contentType(ContentType.JSON)
                .when()
                .delete("http://localhost:8080/flights/delete/CP321")
                .then()
                .statusCode(200);
    }


}
