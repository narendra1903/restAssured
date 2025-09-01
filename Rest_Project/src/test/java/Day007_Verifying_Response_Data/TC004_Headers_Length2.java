package Day007_Verifying_Response_Data;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

//import java.util.concurrent.TimeUnit;
import static java.util.concurrent.TimeUnit.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.*;

public class TC004_Headers_Length2 {
	
	
	@Test
	public void test01()
	{
		
		RestAssured.baseURI="https://www.stackoverflow.com";
		RestAssured.given().get("").then().log().headers().assertThat().
		 
		//header("Content-Type","text/html; charset=utf-8");
		
		header("Content-Type",Integer::parseInt, lessThan(1000)); 
		
		
	}

	
	
}
