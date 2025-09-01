package ABC_037_Data_Provider;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequest {
	
	
	@Test
	public void DisplayAllNodesInWeatherAPI()
	{
	 RestAssured.baseURI = "https://reqres.in";
	 RequestSpecification httpRequest = RestAssured.given();
	 Response response = httpRequest.get("/api/users/2");
	 
	 // First get the JsonPath object instance from the Response interface
	 JsonPath J1 = response.jsonPath();
	 String json   =response.asString();
	 int statuscode=response.getStatusCode();
	
	 System.out.println(statuscode);
	 //System.out.println(json);
	 
	 //System.out.println("User id        :" + J1.get("data.id"));
	 
	 
	}
}
