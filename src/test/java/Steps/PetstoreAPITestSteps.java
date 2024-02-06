package Steps;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class PetstoreAPITestSteps {

    // Allure Step to verify pet not found
    @Step("Verify pet with ID {id} is not found")
    public void verifyPetNotFound(int id) {
        given()
                .pathParam("petId", id)
                .when()
                .get("/pet/{petId}")
                .then()
                .statusCode(404);
    }

    // Allure Step to create a new pet
    @Step("Create a new pet: ID - {id}, Name - {name}, Status - {status}, Expected response - {responseStatus}")
    public void createNewPet(int id, String name, String status, int responseStatus) {
        String newPetJson = "{ \"id\": " + id + ", \"name\": \"" + name + "\", \"status\": \"" + status + "\" }";

        given()
                .contentType(ContentType.JSON)
                .body(newPetJson)
                .when()
                .post("/pet")
                .then()
                .statusCode(responseStatus); // Assuming that the API returns 400 Bad Request for invalid data
    }

    // Allure Step to update an existing pet
    @Step("Update pet: ID - {id}, Name - {name}, Status - {status}, expected Response Status - {responseStatus}")
    public void updatePet(int id, String name, String status, int responseStatus) {
        String updatedPetJson = "{ \"id\": " + id + ", \"name\": \"" + name + "\", \"status\": \"" + status + "\" }";

        given()
                .contentType(ContentType.JSON)
                .body(updatedPetJson)
                .when()
                .put("/pet")
                .then()
                .statusCode(responseStatus); // Assuming that the API returns 404 Not Found for a non-existent pet
    }
    // Allure Step to verify pet details
    @Step("Verify pet details: ID - {id}, Name - {name}, Status - {status}")
    public void verifyPetDetails(int id, String name, String status) {
        given()
                .pathParam("petId", id)
                .when()
                .get("/pet/{petId}")
                .then()
                .statusCode(200)
                .body("id", equalTo(id))
                .body("name", equalTo(name))
                .body("status", equalTo(status));
    }
}
