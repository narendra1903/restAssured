package Day005_Multi_value_Cookies;

import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.response.Response;


public class Detailed_Cookies_Information {

	@Test
	public void getAllCookies_Information_FromResponse()
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
		
		//Cookie detailedCookie ;
		
		for (Map.Entry<String,String> entry : allCookies.entrySet())
		{
			//detailedCookie =response.getDetailedCookie(entry.getKey());
			
			 Cookie cookie = response.getDetailedCookie(entry.getKey());
		        System.out.println("Cookie Comment: " + cookie.getComment());
		        System.out.println("Cookie Domain: " + cookie.getDomain());
		        System.out.println("Cookie Path: " + cookie.getPath());
		        System.out.println("Cookie Expiry Date: " + cookie.getExpiryDate());
		        System.out.println("Cookie Secure: " + cookie.isSecured());
		        
		        
            
            System.out.println("______________________________");
		}
		
	
		
	
		
		
		
		
		String statusLine = response.getStatusLine();
		System.out.println("statusLine  :"+statusLine);
		
		
		// Get status code
		int statusCode = response.getStatusCode();
		System.out.println("statusCode  :"+statusCode);
		
		
	}	
	
}
			
			
			