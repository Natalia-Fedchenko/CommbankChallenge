import Steps.PetstoreAPITestSteps;
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


public class BaseTest {
    public static final String BASE_URL = "https://petstore.swagger.io/v2";
    public PetstoreAPITestSteps steps = new PetstoreAPITestSteps();

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = BASE_URL;
    }

}
