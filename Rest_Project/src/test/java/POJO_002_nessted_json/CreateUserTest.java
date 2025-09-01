package POJO_002_nessted_json;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

import io.restassured.RestAssured; 
import io.restassured.http.ContentType; 
import static io.restassured.RestAssured.*; 
 
public class CreateUserTest { 
    public static void main(String[] args) { 
        // Base URI 
        RestAssured.baseURI = "https://your-api-url.com/api"; 
 
        // Create nested object 
        Address address = new Address("123 Main St", "New York", "10001"); 
 
        // Create parent object 
        User user = new User("Alice", "alice@example.com", 25, address); 
 
        // Send POST request 
        given() 
            .contentType(ContentType.JSON) 
            .body(user) 
        .when() 
            .post("/users") 
        .then() 
            .statusCode(201) 
            .log().body(); 
    } 
}
