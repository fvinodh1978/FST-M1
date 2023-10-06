package activities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Activity2 {

    final static String ROOT_URI = "https://petstore.swagger.io/v2/user";
    private String petId;

    @Test(priority=1)
    public void test_user_add() throws IOException {
        File fileObj = new File("C:\\Users\\054544744\\IdeaProjects\\FST_RestAssured\\src\\test\\java\\resources\\user.json");
        FileInputStream fis = new FileInputStream(fileObj);
        byte[] bytes = new byte[(int)fileObj.length()];
        fis.read(bytes);
        String reqBody= new String(bytes, "UTF-8");
        System.out.println(reqBody);
        Response response = given()
                .headers("Content-Type",ContentType.JSON )
                .body(reqBody)
                .when().post(ROOT_URI);
        System.out.println(response.getBody().asString());
        response.then().body("code", equalTo(200));
        response.then().body("message", equalTo("2023010001"));
    }

    @Test(priority=2)
    public void test_get_user() throws IOException {
        Response response = given()
                .headers("Content-Type",ContentType.JSON )
                .pathParam("username", "fvinodh")
//                .pathParam("petId", "202309002")
                .when().get(ROOT_URI+"/{username}");
        System.out.println(response.getBody().asString());
        String user = response.then().extract().body().path("username");
        System.out.println(user);
        response.then().body("username", equalTo("fvinodh"));
    }

    @Test(priority=3)
    public void test_delete_pet_request() throws IOException {
        Response response = given()
                .headers("Content-Type",ContentType.JSON )
                .pathParam("username", "fvinodh")
                .when().delete(ROOT_URI+"/{username}");
        System.out.println(response.getBody().asString());
        response.then().statusCode(200);
        response.then().body("code", equalTo(200));
        response.then().body("message", equalTo("fvinodh"));
    }
}
