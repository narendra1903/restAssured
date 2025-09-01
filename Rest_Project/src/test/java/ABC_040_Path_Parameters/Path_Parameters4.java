package ABC_040_Path_Parameters;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;


public class Path_Parameters4 {
//https://reqres.in/api/users?page=2
	
	@Test
    public void usePathArguments() {
		
        String baseURI = "https://api.example.com";
        //String endpoint = "/users/{userId}/profile";

        // Specify the path arguments
        String userId = "123";

        // Perform the request with path arguments
        Response response = RestAssured.given()
                .baseUri(baseURI)
                .pathParam("userId", userId) // Set the path argument
                .when()
                .get("/users/{userId}/profile")
                .then()
                .extract()
                .response();

        // Assert the response or perform other operations
        response.then().statusCode(200);
    }


}
