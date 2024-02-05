
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

    @Feature("Petstore Get Pet API Tests")
    public class GetPetTests  {

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
                    .body("name", equalTo("doggie"))
                    .body("status", equalTo("available"));
        }


    }


