package ABC_052_Response_Builder;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseBuilder;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ExampleTest {

    @Test
    public void exampleTest() {
        // Set base URI of the API
        RestAssured.baseURI = "https://api.example.com";

        // Send a GET request and capture the response
        Response originalResponse = given()
            .param("parameter1", "value1")
            .param("parameter2", "value2")
        .when()
            .get("/endpoint")
        .then()
            .extract().response(); // Extract the response

        // Modify the original response using ResponseBuilder
        ResponseBuilder responseBuilder = new ResponseBuilder()
                .clone(originalResponse) // Clone the original response
                .setStatusCode(201) // Change status code to 201
                .setBody("{\"modified\": true}"); // Change response body
        
        // Response modifiedResponse1 = new ResponseBuilder().
    	//	clone(originalResponse).setBody("{\"modified\": true}").build();
    

        // Build the modified response
        Response modifiedResponse = responseBuilder.build();
        
     
            modifiedResponse
            .then()
            .statusCode(201) // Assert status code is now 201
            .body("modified", equalTo(true)); // Assert the modified property is true
    }
}