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

public class TC008_Other_Parts_of_Reponse3_endsWithPath_StartsWith2 {

	
//https://github.com/rest-assured/rest-assured/blob/master/examples/rest-assured-itest-java/src/test/java/io/restassured/itest/java/ResponseAwareMatcherITest.java


	
	

	@Test
	public void test21_Passed()
	{
		RestAssured.baseURI="http://localhost:8080/Sample5.json";
		
		get("").then().
		body("href", 
			and(startsWith("http://localhost:8080/"), 
			endsWithPath("userId")));
		
		get("").then()
		 .body("href", and(
				 startsWith("http://localhost:8080/"),endsWithPath("userId"))
				 );
      
		
		
		
		
	}
	
	
	



}



