package RestAssured2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import io.restassured.http.Header;
import io.restassured.http.Headers;


public class City2 
{
	
	//https://www.toolsqa.com/rest-assured/read-json-response-body-using-rest-assured/
	//https://jsonplaceholder.typicode.com/users
	
	@Test
	public void WeatherMessageBody()
	{
	 RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
	 RequestSpecification httpRequest = RestAssured.given();
	 Response response = httpRequest.get("/Hyderabad");

	 ResponseBody body = response.getBody();

	// System.out.println("Response Body is: " + body.asString());
	 
	 String str =  body.asString();
	 
	// System.out.println("Response Body is: " + str);
	 
	 JsonPath jsonPathEvaluator = response.jsonPath();
	 System.out.println("City received from Response " + jsonPathEvaluator.get("City"));
	 
	
	 
	}
	
}
