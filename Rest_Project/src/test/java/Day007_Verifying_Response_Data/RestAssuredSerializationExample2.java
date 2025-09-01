package Day007_Verifying_Response_Data;

import org.testng.annotations.Test;

import Day007_Verifying_Response_Data.User;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class RestAssuredSerializationExample2 {

	@Test
    public void Test1() {
        // Base URI of the API endpoint
        RestAssured.baseURI = "https://demoqa.com/Account/v1";

        // Create a User object
        User user = new User();
        user.setUsername("john_doe");
        user.setEmail("john.doe@example.com");

        // Send the User object as JSON in the request body
        RestAssured.given()
                .contentType(ContentType.JSON) // Specify content type as JSON
                .body(user) // Serialize the User object
                .when()
                .post("/User") // HTTP POST request to /users endpoint
                .then()
                .statusCode(201); // Assert response status code
    }
}