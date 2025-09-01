package ABC_041_RequestSpec_for_MultipleTests1;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RequestSpecDemo {

	@BeforeTest
	public static RequestSpecification getCommonSpec()
	{
		Map<String, String> cookies = new HashMap<>();
		cookies.put("session_id", "your-session-id");
		cookies.put("user_id", "your-user-id");
		
        // Create a RequestSpecification instance
        RequestSpecification requestSpec = RestAssured.given()
                .baseUri("https://reqres.in")
                .basePath("/api/users")
                //.pathParam("", "")
                .cookies(cookies).
    			.queryParam("page", 2);
    			//.proxy("localhost");
               //.header("Content-Type", "application/json")
              	// .auth().basic("username", "password");
        		//.log().all();
        return requestSpec;  
	}
	
	
	
	
	
	
	
	
	
	@Test
	public  void test_without_parameters()
	{
		System.out.println("______________***************__________________");
		
		Response response=
				RestAssured.given().spec(getCommonSpec()).when().get();
		
		response.getBody().prettyPrint();
		System.out.println("____________&&&&&&&&&&&&__________________");
	}
	
	
	@Test
	public  void test_with_parameters()
	{
		Response response=
				RestAssured.given().spec(getCommonSpec()).
				queryParam("id", 10).
				when().get();
		System.out.println("______________________________");
		response.getBody().prettyPrint();
	}
	
	
	
	
	
	
	
	
	
}
