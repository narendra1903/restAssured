package ABC_044_Response_Time;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import io.restassured.path.json.JsonPath;

public class MeasuringResponseTime2 
{
	
	@Test
	public void WeatherMessageBody()
	{
	 RestAssured.baseURI = "http://localhost:8080";
	 RequestSpecification httpRequest = RestAssured.given()
			 .contentType(ContentType.JSON);

	 long timeInSeconds = httpRequest.get("/lotto.json").timeIn(TimeUnit.SECONDS);
	
	 
	 System.out.println(timeInSeconds);
	 	 
	 

	
	 
	}
}
