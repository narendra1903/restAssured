package Pojo_Classes;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class RestAssured_DeSerializationExample {

	@Test
    public void Test1() {
		
		  RestAssured.baseURI = "http://localhost:8080";

	        // Send an HTTP GET request to retrieve user information
	        User user = RestAssured.given()
	                .contentType(ContentType.JSON) // Specify content type as JSON
	                .when()
	                .get("/user.json") // HTTP GET request to /users/{id} endpoint
	                .then()
	                .statusCode(200) // Assert response status code
	                .extract()
	                .as(User.class); // Deserialize JSON response into User object

	        // Now you can use the User object as needed
	        System.out.println("Name: " + user.getName());
	        System.out.println("Salary: " + user.getSalary());
	        System.out.println("Age: " + user.getAge());
	        
    }
}