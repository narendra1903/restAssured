package Day007_Verifying_Response_Data;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

//import java.util.concurrent.TimeUnit;
import static java.util.concurrent.TimeUnit.*;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class TC001_Response_Body {

	@Test
	public void test01()
	{
		
		RestAssured.baseURI="https://reqres.in/";
		RestAssured.basePath="api/users";
		long timeInMs = RestAssured.get("").time();
		
		long timeInSeconds = get("").timeIn(SECONDS);
		
	
		
	}
	
	@Test public void
    response_time_can_be_be_converted() {
		
		
		RestAssured.baseURI="https://reqres.in/";
		RestAssured.basePath="api/users";
		
        long timeNanos = get("").timeIn(NANOSECONDS);
        long timeMillis = get("").timeIn(MILLISECONDS);
        
        System.out.println(timeNanos);
        System.out.println(timeMillis);
        
        
     
        
    }
	
	@Test public void
    response_time_can_be_validated_with_explicit_time_unit() {
		
		RestAssured.baseURI="https://reqres.in/";
		RestAssured.basePath="api/users";
		
		when().
	      get("").
	      then().
	      time(lessThan(2000L)); // Milliseconds
		
		
		when().
	      get("").
	      then().
	      time(lessThan(2L), SECONDS);
    }



	
	
}
