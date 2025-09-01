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

public class TC002_Cookies22 {

	@Test
	public void test01()
	{
		
		RestAssured.baseURI="https://reqres.in/api/users";
		//RestAssured.basePath="api/users";
		
		// Response response = RestAssured.get("https://www.stackoverflow.com");
		
		Cookie cookie1 =new Cookie.Builder("username", "John").
				setComment("comment 1").build();
		
		Cookie cookie2 =new Cookie.Builder("token", "1234").
				setComment("comment 2").build();
		
		Cookies cookies = new Cookies(cookie1, cookie2);
		
		RestAssured.given().
		cookie(cookie1).
		cookie(cookie2).
		log().all().
		when().get().
		then().assertThat().statusCode(200);
	
		
	
		
	}
	


	
	
}
