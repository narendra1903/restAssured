package RestAssured3;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class QueryParameters 
{
	
	//https://reqres.in/api/users?page=2&id=5
	
	//https://techndeck.com/get-request-using-rest-assured/
	//http://dummy.restapiexample.com/api/v1/employees
	

	
	@Test
	public void filterUser() {
 
	
 
		try {
			
			RestAssured.baseURI = "https://reqres.in/api";
			Response response = null;
			RequestSpecification request = RestAssured.given();
		
			
			request.queryParam("page", "2");
			request.queryParam("id", 5);
			response =request.get("/users");
			
			System.out.println("Response :" + response.asString());
			System.out.println("Status Code :" + response.getStatusCode());
			
		} catch (Exception e) {e.printStackTrace();}
 

 
	}

	
	
	
	
	
}
