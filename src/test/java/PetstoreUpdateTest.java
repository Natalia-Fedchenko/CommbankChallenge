import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Feature("Petstore UPDATE PET Tests")
public class PetstoreUpdateTest extends BaseTest {
    @Test
    @Story("Update an existing pet")
    @Description("Verify that an existing pet can be successfully updated")
    public void testUpdatePet() {
        steps.updatePet(1, "updatedPet", "sold", 200);
    }

    @Test
    @Story("Attempt to Update a non-existent pet")
    @Description("Verify that the API responds appropriately when attempting to update a non-existent pet")
    public void testUpdateNonExistentPet() {
        steps.updatePet(999999, "updatedPet", "sold", 400);
    }

}
