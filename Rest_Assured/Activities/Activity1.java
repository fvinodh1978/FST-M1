package activities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Activity1 {

    final static String ROOT_URI = "https://petstore.swagger.io/v2/pet";
    private String petId;

    @Test(priority=1)
    public void test_post_request() throws IOException {
        File fileObj = new File("C:\\Users\\054544744\\IdeaProjects\\FST_RestAssured\\src\\test\\java\\resources\\restInput1.json");
        FileInputStream fis = new FileInputStream(fileObj);
        byte[] bytes = new byte[(int)fileObj.length()];
        fis.read(bytes);
        String reqBody= new String(bytes, "UTF-8");
        System.out.println(reqBody);
        Response response = given()
                .headers("Content-Type",ContentType.JSON )
                .body(reqBody)
                .when().post(ROOT_URI);
        Integer id = response.then().extract().body().path("id");
        System.out.println(id);
        System.out.println(response.getBody().asString());
        response.then().body("name", equalTo("doggie"));
        petId=id.toString();
    }

    @Test(priority=2)
    public void test_get_pet_request() throws IOException {
        Response response = given()
                .headers("Content-Type",ContentType.JSON )
                .pathParam("petId", petId)
//                .pathParam("petId", "202309002")
                .when().get(ROOT_URI+"/{petId}");
        String name = response.then().extract().body().path("name");
        System.out.println(name);
        System.out.println(response.getBody().asString());
        response.then().body("name", equalTo("doggie"));
    }

    @Test(priority=3)
    public void test_delete_pet_request() throws IOException {
        Response response = given()
                .headers("Content-Type",ContentType.JSON )
                .pathParam("petId", petId)
                .when().delete(ROOT_URI+"/{petId}");
        System.out.println(response.getBody().asString());
        response.then().statusCode(200);
        response.then().body("code", equalTo(200));
        response.then().body("message", equalTo("202309002"));
    }
}
