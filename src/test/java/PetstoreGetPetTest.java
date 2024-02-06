import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Feature("Petstore GET PET Tests")
public class PetstoreGetPetTest extends BaseTest {
    @Test
    @Story("Get a pet by ID - Positive")
    @Description("Verify that the correct pet details are returned when getting a pet by ID")
    public void testGetPetById() {
        // Step with a description for better reporting
        steps.verifyPetDetails(1, "doggie", "available");
    }
    @Test
    @Story("Attempt to Get a pet with invalid ID")
    @Description("Verify that the API responds appropriately when attempting to get a pet with an invalid ID")
    public void testGetPetWithInvalidId() {
        // Step with a description for better reporting
        steps.verifyPetNotFound(999999);
    }
}
