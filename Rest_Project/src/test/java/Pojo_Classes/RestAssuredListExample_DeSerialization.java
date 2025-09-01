package Pojo_Classes;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;

import java.util.List;

public class RestAssuredListExample_DeSerialization {
	
    public static void main(String[] args) {
        // Specify the base URL to the RESTful web service
        RestAssured.baseURI = "https://api.example.com";

        // Make a GET request to the /users endpoint
        Response response = RestAssured.given()
                .when()
                .get("/users")
                .then()
                .statusCode(200)
                .extract()
                .response();
        


        // Deserialize the JSON response to a List of User objects
        List<User> users = response.as(new TypeRef<List<User>>() {});

        // Print the list of User objects
        for (User user : users) {
            System.out.println(user);
        }
    }
}