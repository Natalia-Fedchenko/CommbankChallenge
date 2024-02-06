import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


@Feature("Petstore CREATE PET Tests")
public class PetstoreCreatePetTest extends BaseTest {
    @Test
    @Story("Create a new pet")
    @Description("Verify that a new pet can be successfully created")
    public void testCreateNewPet() {
        steps.createNewPet(10001, "newPet", "available", 200);
    }

    @Test
    @Story("Attempt to Create a new pet with existing id")
    @Description("Verify that the API responds appropriately (status 400) when attempting to create a new pet with existing id ")
    public void testCreateNewPetWhenExists() {
        steps.createNewPet(10001, "newPet", "available", 400);
    }

    @Test
    @Story("Attempt to Create a new pet with invalid data - empty name")
    @Description("Verify that the API responds appropriately (status 400) when attempting to create a new pet with invalid data")
    public void testCreateNewPetWithInvalidData() {
        steps.createNewPet(10002, "", "available", 400); // Empty name
    }
}
