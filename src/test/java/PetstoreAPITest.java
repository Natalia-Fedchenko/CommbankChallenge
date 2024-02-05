import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
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
        given()
                .pathParam("petId", 1)
                .when()
                .get("/pet/{petId}")
                .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("name", equalTo("dog"))
                .body("status", equalTo("available"));
    }

    @Test
    @Story("Create a new pet")
    @Description("Verify that a new pet can be successfully created")
    public void testCreateNewPet() {
        String newPetJson = "{ \"id\": 10001, \"name\": \"newPet\", \"status\": \"available\" }";

        given()
                .contentType(ContentType.JSON)
                .body(newPetJson)
                .when()
                .post("/pet")
                .then()
                .statusCode(200);
    }

    @Test
    @Story("Update an existing pet")
    @Description("Verify that an existing pet can be successfully updated")
    public void testUpdatePet() {
        String updatedPetJson = "{ \"id\": 1, \"name\": \"updatedPet\", \"status\": \"sold\" }";

        given()
                .contentType(ContentType.JSON)
                .body(updatedPetJson)
                .when()
                .put("/pet")
                .then()
                .statusCode(200);
    }
}
