package ABC_038_Get_Post_Put_Patch_Delete;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class Day006_Delete_Request {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    
    @Test
    public void deleteRequest() {
        Response response = given()
                .header("Content-type", "application/json")
                .when()
                .delete("/posts/101")
                .then()
                .extract().response();

        System.out.println("Record - deleted - Response code :"+response.getStatusCode());
        Assertions.assertEquals(200, response.statusCode());
    }
}