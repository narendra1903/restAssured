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

public class TC002_Validate_Header_In_Response {
	
	
	@Test
	public void Test1()
	{
	
		RestAssured.baseURI="https://www.stackoverflow.com";
		
		//Validates cookies in the response object
		
		RestAssured
		.given().get("").then().assertThat().
		header("headerName", "headerValue");
		
		RestAssured
		.given().get("").then().assertThat().
		headers("headerName1", "headerValue1", 
				"headerName2", "headerValue2");
		
		RestAssured
		.given().get("").then().assertThat().
		headers("headerName1", "headerValue1", 
				"headerName2", containsString("Value2"));
		
	
		
		
	}
	


	
	
}
