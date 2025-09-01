package Day007_Verifying_Response_Data;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

//import java.util.concurrent.TimeUnit;
import static java.util.concurrent.TimeUnit.*;
import io.restassured.RestAssured;
import io.restassured.http.Cookie;
import io.restassured.http.Cookie.Builder;
import io.restassured.response.Response;
import io.restassured.http.Cookies;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import java.util.List;
import java.util.Map;

public class TC002_Cookies23 {
	
	
	String provvalue="";
	
	@Test
	public void Test1()
	{
		Response response= 
				RestAssured
					.given()
					.get("https://www.stackoverflow.com")
					.then()
					.extract()
					.response();
		
		provvalue= response.getCookie("prov");
		
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
	
	
	

	@Test
	public void Test2()
	{
		
		RestAssured.baseURI="https://www.stackoverflow.com";
		
		Response response= 
				RestAssured
					.given()
					.get("https://www.stackoverflow.com")
					.then()
					.extract()
					.response();
		
		provvalue= response.getCookie("prov");
		System.out.println("provvalue :"+provvalue);
		
		//RestAssured.basePath="api/users";
		
		// Response response = RestAssured.get("https://www.stackoverflow.com");
		
		Cookie cookie1 =new Cookie.Builder("username", "Johns").
				setComment("comment 1").build();
		
		Cookie cookie2 =new Cookie.Builder("tokens", "1234").
				setComment("comment 2").build();
		
		Cookies cookies3 = new Cookies(cookie1, cookie2);
		
		RestAssured.given().
		cookies(cookies3).
		log().all().
		when().get().
		then().assertThat().statusCode(200);
	
		RestAssured.given().get("").
		then().assertThat().cookie("prov", provvalue);
		//cdcc1600-2564-4478-9b8c-49436529dc97
	
		RestAssured.given().get("").
		then().assertThat().cookies("prov", containsString(provvalue));
	
		
	}
	


	
	
}
