package Day007_Verifying_Response_Data;

import java.util.List;

import org.testng.annotations.Test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class RetrievingResponseHeaders {

	@Test
	public void getALlHeadersFromResponse()
	{
		Response response= 
				RestAssured
					.given()
					.get("https://restful-booker.herokuapp.com/booking/1")
					.then()
					.extract()
					.response();
		
		System.out.println("All Headers of response are :- ");
		Headers allHeaders = response.getHeaders();
		
		for(Header header : allHeaders)
		{
			System.out.print(header.getName() +" : ");
			System.out.println(header.getValue());
			System.out.println("_____________________");
		}
		
		System.out.println("Value of Header Content-Type : "+response.getHeader("Content-Type"));
		
		
		//List<String> l1=allHeaders.getValues("");
		//System.out.print(l1);
		
		
	}	
	
}
			
			
			