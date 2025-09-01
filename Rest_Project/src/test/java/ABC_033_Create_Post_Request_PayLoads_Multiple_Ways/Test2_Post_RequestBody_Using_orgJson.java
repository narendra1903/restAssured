package ABC_033_Create_Post_Request_PayLoads_Multiple_Ways;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyExtractionOptions;
import io.restassured.response.ValidatableResponse;

public class Test2_Post_RequestBody_Using_orgJson {
	
  @Test
  public void Post_RequestBody_Using_HashMap( )
	{


	// JSON payload for the POST request
      User requestBody = new User();
      requestBody.setName("Harry Potter3");
      requestBody.setGender("Male");
      requestBody.setEmail("hoggwarts33@wiz.com");
      requestBody.setStatus("active");
      
	    RestAssured
	        .given()
	            .header("Authorization","Bearer c005c96081fd4f9205d53b5f0e8d0aab4eac0c63ad282de7aeda1f2b2fd0bdc6")
	            .baseUri("https://gorest.co.in/public/v1/users/")
	            .contentType(ContentType.JSON)
	            .body(requestBody)
	            .log()
	            .body()
	       .when()
	           .post()
	        .then()
	            //.assertThat().statusCode(201)
	            .log().body();
		

	}
  
}
