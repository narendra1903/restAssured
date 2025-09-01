package RestAssured2;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class City3 
{
	
	//https://www.toolsqa.com/rest-assured/read-json-response-body-using-rest-assured/
	//https://jsonplaceholder.typicode.com/users
	
	@Test
	public void WeatherMessageBody()
	{
	 RestAssured.baseURI = "https://demoqa.com/utilities/weather/city";
	 RequestSpecification httpRequest = RestAssured.given();
	 Response response = httpRequest.get("/Hyderabad");
	 

	 
	 String body = response.getBody().asString();
	 
	 //String headerValue = response.getHeader("headerName");
	// String cookieValue = response.getCookie("cookieName");
	 
	 System.out.println("Response Body1 is =>  " + response.asString());
	 
	
	 
	// System.out.println("headerValue  is =>  " + headerValue);
	// System.out.println("cookieValue  is =>  " + cookieValue);
	 
	 System.out.println("Response Body is =>  " + body);
	 
	}
}
