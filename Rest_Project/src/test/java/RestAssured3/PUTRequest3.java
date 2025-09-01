package RestAssured3;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class PUTRequest3 
{

	@Test
	public void RegistrationSuccessful1()
	{		
		RestAssured.baseURI ="http://dummy.restapiexample.com/api/v1";
		RequestSpecification request = RestAssured.given();
		Response response = null;

		String requestBody = "{\n" +
				"  \"name\": \"PUT_tammy33\",\n" +
				"  \"salary\": \"90000\",\n" +
				"  \"age\": \"90\"\n" +
				"}";
		
		//32246
		
		request.body(requestBody);
		request.contentType(ContentType.JSON);
		response = request.put("/update/32246");
		

		int statusCode = response.getStatusCode();
		System.out.println("The status code recieved: " + statusCode);
		System.out.println("Response body: " + response.body().asString());
 
	}
	
	
	

	//https://techndeck.com/get-request-using-rest-assured/
	//http://dummy.restapiexample.com/api/v1/employees
		
	
	
}
