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

public class TC004_Headers_Length {
	
	@Test
	public void Test23()
	{
		 RestAssured.baseURI = "https://www.stackoverflow.com";


	        Response response = given()
	                                .get("");
	        
	        

	        // Extract the value of the Content-Type header
	        String contentTypeHeaderValue = response.getHeader("Content-Type");

	        // Extract the length of the Content-Type header value
	        int contentTypeHeaderLength = contentTypeHeaderValue.length();

	        // Perform further operations with the extracted length
	        System.out.println("Length of Content-Type header: " + contentTypeHeaderLength);
	
	    	
	}

	@Test
	public void test01()
	{
		
		RestAssured.baseURI="https://www.stackoverflow.com";
		RestAssured.given().get("").then().log().headers().assertThat().
		header("Content-Type","text/html; charset=utf-8");
		
			
		
		
		
		
		
		
		
		 // Send a GET request to retrieve the resource
      /*  given()
            .get("")
        .then()
            .assertThat()
            .header("Content-Type", headerValue -> {
                assertThat(headerValue.length(), lessThan(1000)); // Adjust the threshold as needed
            });*/
		
	}
	
	
	public void Test2()
	{
		
		RestAssured.baseURI="https://www.stackoverflow.com";
		RestAssured.given().
		when().
	      get().
	      then().
	      header("Content-Type",Integer::parseInt, lessThan(1000)); 
		
		//String givenString = "42";
	    //int result = Integer.parseInt(givenString);
	    
		
	     /* header("Content-Type", headerValue -> {
              assertThat(headerValue.length(), lessThan(100));
              });*/
	}

	
	
}
