package TestSteps;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;
public class MyStepdefs {



    @Given("A List of Passengers")
    public void aListOfPassengers() {

    }

    @And("I Perform GET for the Passenger {string}")
    public void iPerformGETForThePassenger(String postNumber) {
        ValidatableResponse validatableResponse=when().get(String.format("http://localhost:8080/passengers/%s", postNumber)).
                then().body("firstName", Matchers.is("Philip"));
    }

    @Then("I Should see the FirstName {string}")
    public void iShouldSeeTheFirstName(String arg0) {

    }

    @And("I Perform GET for passenger list")
    public void iPerformGETForPassengerList() {

       RestAssured.given()
                .then()
                .expect()
                .statusCode(200)
                .when()
                .get("http://localhost:8080/passengers/get");
    }
    //@SneakyThrows
    @And("I Add Passenger to List")
    public void iAddPassengerToList() {

        JSONObject request = new JSONObject();
        request.put("passportNo", "123456");
        request.put("firstName", "John");
        request.put("lastName", "Kennedy");
        request.put("flightNo", "SQ528");
        request.put("email", "john@gmail.com");
        request.put("phone", "456321");

        ValidatableResponse validatableResponse=given()
                .contentType(ContentType.JSON)
                .body(request.toString())
                .when()
                .post("http://localhost:8080/passengers/post")
                .then()
                .log()
                .all()
                .statusCode(200);
    }



    @And("I Perform GET for one Passenger {string}")
    public void iPerformGETForOnePassenger(String arg0) {
        given().
                when()
                .get(String.format("http://localhost:8080/passengers/%s",arg0))
                .then()
                .statusCode(200)
                .body("passportNo",equalTo("123321"))
                .body("firstName",equalTo("Philip"))
                .body("lastName",equalTo("David"))
                .body("flightNo",equalTo("AI231"))
                .body("phone",equalTo("984352354"))
                .body("email",equalTo("jack@gmail.com")).log().all();

    }

    @And("I Perform DELETE operation")
    public void iPerformDELETEOperation() {
        JSONObject request = new JSONObject();
        given()
                .body(request.toJSONString())
                .when()
                .delete("http://localhost:8080/passengers/delete/123456")
                .then()
                .statusCode(200)
                .log().all();
    }

    @And("I Perform UPDATE operation")
    public void iPerformUPDATEOperation() {
        JSONObject request =  new JSONObject();
        request.put("passportNo", "123456");
        request.put("firstName", "John");
        request.put("lastName", "Kennedy");
        request.put("flightNo", "SQ528");
        request.put("email", "john@gmail.com");
        request.put("phone", "456321786");


        ValidatableResponse validatableResponse= given()
                .contentType(ContentType.JSON)
                .body(request.toString())
                .when()
                .put("http://localhost:8080/passengers/update/123456")
                .then()
                .log()
                .all()
                .statusCode(200);

    }

    @Then("I Should see the list")
    public void iShouldSeeTheList() {
    }

    @Given("A new list of pasengers")
    public void aNewListOfPasengers() {
    }
}







