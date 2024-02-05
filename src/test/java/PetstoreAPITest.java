import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@Feature("Petstore API Tests")
public class PetstoreAPITest {

    private static final String BASE_URL = "https://petstore.swagger.io/v2";

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = BASE_URL;
    }

    @Test
    @Story("Get a pet by ID")
    @Description("Verify that the correct pet details are returned when getting a pet by ID")
    public void testGetPetById() {
        // Step with a description for better reporting
        verifyPetDetails(1, "doggie", "available");
    }

    @Test
    @Story("Create a new pet")
    @Description("Verify that a new pet can be successfully created")
    public void testCreateNewPet() {
        // Step with a description for better reporting
        createNewPet(10001, "newPet", "available");
    }

    @Test
    @Story("Update an existing pet")
    @Description("Verify that an existing pet can be successfully updated")
    public void testUpdatePet() {
        // Step with a description for better reporting
        updatePet(1, "updatedPet", "sold");
    }

    // Allure Step to verify pet details
    @Step("Verify pet details: ID - {id}, Name - {name}, Status - {status}")
    private void verifyPetDetails(int id, String name, String status) {
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

    // Allure Step to create a new pet
    @Step("Create a new pet: ID - {id}, Name - {name}, Status - {status}")
    private void createNewPet(int id, String name, String status) {
        String newPetJson = "{ \"id\": " + id + ", \"name\": \"" + name + "\", \"status\": \"" + status + "\" }";

        given()
                .contentType(ContentType.JSON)
                .body(newPetJson)
                .when()
                .post("/pet")
                .then()
                .statusCode(200);
    }

    // Allure Step to update an existing pet
    @Step("Update pet: ID - {id}, Name - {name}, Status - {status}")
    private void updatePet(int id, String name, String status) {
        String updatedPetJson = "{ \"id\": " + id + ", \"name\": \"" + name + "\", \"status\": \"" + status + "\" }";

        given()
                .contentType(ContentType.JSON)
                .body(updatedPetJson)
                .when()
                .put("/pet")
                .then()
                .statusCode(200);
    }
}
