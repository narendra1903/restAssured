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

public class TC007_Other_Parts_of_Reponse3_endsWithPath_StartsWith {

	
//https://github.com/rest-assured/rest-assured/blob/master/examples/rest-assured-itest-java/src/test/java/io/restassured/itest/java/ResponseAwareMatcherITest.java


	
	

	
	public void test21_Passed()
	{
		
		
		RestAssured.baseURI="http://localhost:8080/Sample5.json";
		
		/*Response res=get("").then().extract().response();
		String HREF=res.path("href");
		System.out.println(HREF);*/
		
		//get("").then().
		//body("href", endsWith("26"));
		
		//get("").then().
		//body("href", endsWithPath("userId"));
		
		//get("").then().
		//body("href", startsWith("http://localhost:8080/"));
		
		
		
		
		get("").then().
		body("href", 
			and(startsWith("http:/localhost:8080/"), 
			endsWithPath("userId")));
		
		//get("").then().
		//body("href", startsWith("http://localhost:8080/"));

		
	}
	
	@Test
	 public void validateHref() {
	        // Define the base URL
	        RestAssured.baseURI = "http://localhost:8080/Sample5.json";

	        // Send a GET request to retrieve the resource
	        RestAssured.given()
	            .get("")
	        .then()
	            .assertThat()
	            .body("href", startsWith("http://localhost:8080/"))
	            .and()
	            .body("href", endsWithPath("userId"));
	    }
	



}



