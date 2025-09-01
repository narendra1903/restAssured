package ABC_001_POST;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test_002_PostMethod2 {

	@Test
	public void test03()
	{
	    RestAssured.baseURI = "https://api.example.com";
        RestAssured.basePath = "/v1/resources";
		
		 // Bearer token for authentication
        String token = "your_bearer_token_here";
        
       RequestSpecification  requestSpec=RestAssured.given()
    		   
		.header("Content-type","application/json")
		.header("Authorization", "Bearer " + token)         
        .header("Content-Type", "application/json") 
        .header("Content-type","application/json")
        .contentType(ContentType.JSON)
        .header("Content-Length","323")
        .header("Accept", "application/json")
        .pathParam("", "")
        .queryParams("","");
		
	

        Response response = RestAssured. given()
            .spec(requestSpec)  
            .body("requestbody")
            .when()
            .post("/{id}")    
            .then()
            .statusCode(201)  
            .extract().response();

        // Print response
        System.out.println("Response: " + response.asString());
		
		
		
		
		

	}
}
