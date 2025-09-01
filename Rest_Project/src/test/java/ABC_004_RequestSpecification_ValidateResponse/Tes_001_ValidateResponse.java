package ABC_004_RequestSpecification_ValidateResponse;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;


public class Tes_001_ValidateResponse {
//https://reqres.in/api/users/2
	
	
	@Test(enabled=true)
	public void GetSingleUserUsingValidatableResponse()
	{
		//specify base URL
		baseURI = "https://reqres.in/api/users/2";
		
		//Get Request specifcation of the request
		RequestSpecification requestSpec =  given();
	
		//call get method
		Response response = requestSpec.get();
		
		
		ValidatableResponse validateRes = response.then();
		
		//status code 
		validateRes.statusCode(200);
		
	//	System.out.println("second validation");
		//status line
		validateRes.statusLine("HTTP/1.1 200 OK");
		
		
	}
	
	
	
}
