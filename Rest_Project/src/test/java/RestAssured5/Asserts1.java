package RestAssured5;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import io.restassured.path.json.JsonPath;

public class Asserts1 
{
	
	@Test
	public void WeatherMessageBody()
	{
	 RestAssured.baseURI = "https://demoqa.com/utilities/weather/city";
	 RequestSpecification httpRequest = RestAssured.given();
	 Response response = httpRequest.get("/Hyderabad");
	 
	 String JSON = response.getBody().asString();
	 System.out.println("Response Body1 is =>  " + response.asString());
	 	 
	 System.out.println("Response Body is =>  " + JSON);
	 
	 JsonPath jsonPathEvaluator = response.jsonPath();
	 System.out.println("City received from Response        : " + jsonPathEvaluator.get("City"));
	 System.out.println("Temperature received from Response : " + jsonPathEvaluator.get("Temperature"));
	 System.out.println("Humidity received from Response     : " + jsonPathEvaluator.get("Humidity"));
	 
	 int statusCode = response.getStatusCode();
	 Assert.assertEquals(statusCode, 200 , "Correct status code returned");
	 
	 
	 System.out.println("statusCode     : " + statusCode);
	 
	 String statusLine = response.getStatusLine();
	 Assert.assertEquals(statusLine,"HTTP/1.1 200 OK","Correct status code returned");
	 
	 
	 System.out.println("statusLine     : " + statusLine);
	 
	 Assert.assertEquals(JSON.contains("Hyderabad"), true , "Response body contains Hyderabad");
	 Assert.assertEquals(JSON.toLowerCase().contains("hyderabad") , true ,"Response body contains Hyderabad");

	 System.out.println("Weather description received from Response " + jsonPathEvaluator.get("Weather"));
	 System.out.println("WindSpeed received from Response " + jsonPathEvaluator.get("WindSpeed"));
	 System.out.println("WindDirectionDegree received from Response " + jsonPathEvaluator.get("WindDirectionDegree"));
	 
	// System.out.println("Weather description : " + jsonPathEvaluator.get("Weather Description"));
	// System.out.println("City received from Response " + jsonPathEvaluator.get("Wind Speed"));
	// System.out.println("City received from Response " + jsonPathEvaluator.get("Wind Direction degree"));
	 
	 /*
	 Response interface gives you a mechanism to extract nodes based on a given JsonPath. 
	 There is a method called Response.JsonPath(), which returns a io.restassured.path.json.JsonPath Object. 
	 This object can be used to further query specific parts of the Response Json.*/
	 
	}
}
