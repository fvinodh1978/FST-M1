package activities;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class Activity3 {

    final static String ROOT_URI = "https://petstore.swagger.io/v2/user";
    private String petId;

    // Declare request specification
    private RequestSpecification requestSpec;
    // Declare response specification
    private ResponseSpecification responseSpec;

    @BeforeClass
    public void setup(){
        requestSpec = new RequestSpecBuilder()
                // Set content type
                .setContentType(ContentType.JSON)
                // Set base URL
                .setBaseUri("https://petstore.swagger.io/v2/pet")
                // Build request specification
                .build();

        responseSpec = new ResponseSpecBuilder()
                // Check status code in response
                .expectStatusCode(200)
                // Check response content type
                .expectContentType("application/json")
                // Check size of the array in a JSON response
                .expectBody("status", equalTo("alive"))
                // Build response specification
                .build();
    }

    @Test(priority=1, dataProvider = "petInfoProvider")
    public void test_user_add(int id, String name, String status) throws IOException {
        Map pet = new HashMap<>();
        pet.put("id", id);
        pet.put("name", name);
        pet.put("status", status);

        Response response = given()
                .spec(requestSpec)
                .body(pet)
                .when().post();
        System.out.println(response.getBody().asString());
        response.then().spec(responseSpec);
    }

    @Test(priority=2, dataProvider = "petInfoProvider")
    public void test_get_user(int id, String name, String status) throws IOException {
        Response response = given()
                .spec(requestSpec)
                .pathParam("petId", id)
                .when().get("/{petId}");
        System.out.println(response.getBody().asString());
        response.then().spec(responseSpec).body("name", equalTo(name));
    }

    @Test(priority=3, dataProvider = "petInfoProvider")
    public void test_delete_pet_request(int id, String name, String status) throws IOException {
        Response response = given()
                .spec(requestSpec)
                .pathParam("petId", id)
                .when().delete("/{petId}");
        System.out.println(response.getBody().asString());
        response.then().body("code", equalTo(200), "message", equalTo(Integer.toString(id)));
    }

    @DataProvider
    public Object[][] petInfoProvider() {
        // Setting parameters to pass to test case
        Object[][] testData = new Object[][] {
                { 77232, "Riley", "alive" },
                { 77233, "Hansel", "alive" }
        };
        return testData;
    }
}
