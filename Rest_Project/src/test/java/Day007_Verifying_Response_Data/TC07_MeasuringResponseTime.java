package Day007_Verifying_Response_Data;

import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import io.restassured.path.json.JsonPath;

public class TC07_MeasuringResponseTime 
{
	
	@Test
	public void WeatherMessageBody()
	{
	 RestAssured.baseURI = "https://reqres.in/";
	 RequestSpecification httpRequest = RestAssured.given()
			 .contentType(ContentType.JSON);

	 long timeInMs = httpRequest.get("api/users").time();

	 
	 System.out.println(timeInMs);
	 	 

	 
	
	 
	}
}
