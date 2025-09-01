package Day007_Verifying_Response_Data;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.when;
import static io.restassured.matcher.ResponseAwareMatcherComposer.and;
import static io.restassured.matcher.ResponseAwareMatcherComposer.or;
import static io.restassured.matcher.RestAssuredMatchers.endsWithPath;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.matcher.ResponseAwareMatcherComposer.*;

public class TC006_Other_Parts_of_Reponse2_endsWith_StartsWith {

	
		

//https://github.com/rest-assured/rest-assured/blob/master/examples/rest-assured-itest-java/src/test/java/io/restassured/itest/java/ResponseAwareMatcherITest.java


	
	
	@Test
	public void test1()
	{
		RestAssured.baseURI="http://localhost:8080/Sample5.json";
		
		Response res=RestAssured.get();
		String specificValue = res.path("href");
		
		//String str=res.asString();
		
		System.out.println("HREF VALUE :"+specificValue);
		
		assertThat(specificValue, startsWith("http://localhost:8080/"));
		assertThat(specificValue, endsWith("25"));
		
		//System.out.println(res.asString());
	
	}
	
	

	
	public void test21_Passed()
	{
		RestAssured.baseURI="http://localhost:8080/Sample5.json";
		
		//get("").then().
		//body("href", endsWithPath("25"));

		Response res=RestAssured.given().
				
				get("").then().
				body("href", endsWith("25")).extract().response();
		
		
		Response res1=RestAssured.given().
				get("").then().
				body("href", startsWith("http://localhost:8080/")).extract().response();
				
		//System.out.println(res.asString());
	
	}
	



}



