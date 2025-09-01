package ABC_043_Headers_Cookies;

import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.response.Response;


public class RetrievingResponseCookies {

	@Test
	public void getALlHeadersFromResponse()
	{
		Response response= 
				RestAssured
					.given()
					.get("https://www.stackoverflow.com")
					.then()
					.extract()
					.response();
		
		//System.out.println("All Headers of response are :- ");
		
		//Map<String, String> allCookies = response.getCookies();

		Map<String, String> allCookies = response.getCookies();
		
		for (Map.Entry<String,String> entry : allCookies.entrySet())
		{
            System.out.println("Key = " + entry.getKey() + 
                             ", Value = " + entry.getValue()); 
            System.out.println("_______________________________");
		}
		
		
	}	
	
}
			
			
			