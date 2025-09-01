package RestAssured3;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class JSONPATH2 {
	
	@Test
	public void DisplayAllNodesInWeatherAPI()
	{
		RestAssured.baseURI = "http://demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/Hyderabad");
	 
		String json   =response.asString();
		JsonPath J1 = new JsonPath(json);
	 
		System.out.println("City received from Response        :" + J1.get("City"));
		System.out.println("Temperature received from Response :" + J1.get("Temperature"));
	 
		//System.out.println("Humidity received from Response " + jsonPathEvaluator.get("Humidity"));
		//System.out.println("Weather description received from Response " + jsonPathEvaluator.get("Weather Description"));
		//System.out.println("City received from Response " + jsonPathEvaluator.get("Wind Speed"));
		//System.out.println("City received from Response " + jsonPathEvaluator.get("Wind Direction degree"));
	 
	}
}
