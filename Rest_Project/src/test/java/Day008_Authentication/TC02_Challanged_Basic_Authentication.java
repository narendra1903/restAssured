package Day008_Authentication;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

//How to Handle Authentication in RestAssured
//https://www.youtube.com/watch?v=w-1EvCAszgE

public class TC02_Challanged_Basic_Authentication {
  
	@Test
	  public void Test1() {
		  
		  
		int code=   RestAssured.given().auth().
				  basic("username", "password").when().
				  get("/secured/hello").getStatusCode();
	  }

	
	
	
	
@Test
public void Test2() {
	  
	  
	  RestAssured.given().auth().
	  basic("username", "password").when().
	  get("/secured/hello").then().statusCode(200);
}

	
	
}
