package ABC_004_RequestSpecification_ValidateResponse;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;


public class Test_002_RequestSpecification {
//https://reqres.in/api/users/2
	
	
	
	@Test(enabled = true )
	public void GetSingleUser()
	{
		//specify base URL
		RestAssured.baseURI = "https://reqres.in/api/users/2";
		
		//Get Request specifcation of the request
		RequestSpecification requestSpec = RestAssured.given();
	
		//call get method
		Response response = requestSpec.get();
		
		
		//gets response code
		int statusCode = response.getStatusCode();
		
		//validate actual status code with expected
		
		//Assert.assertEquals(statusCode/*actual status code*/,200/*expected status code*/,"incorrect status code received");		
		
		String statusLine = response.getStatusLine();
		
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK","incorrect status line returned");
		
		Assert.assertEquals(statusCode,200);
	}
	
	
}
