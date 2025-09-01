package Day008_Authentication;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

//How to Handle Authentication in RestAssured
//https://www.youtube.com/watch?v=w-1EvCAszgE

public class TC01_Preemptive_Basic_Authentication {
	
	//https://www.youtube.com/watch?v=w-1EvCAszgE
	
	@Test
	  public void Test1() {
		  
		  
		int code=  RestAssured.given().auth().preemptive().
		  basic("username", "password").
		  when().
		  get("/secured/hello").getStatusCode();
	  }
	
	
	
	
	
	
	
	
  @Test
  public void Test2() {
	  
	  
	  RestAssured.given().auth().preemptive().
	  basic("username", "password").
	  when().
	  get("/secured/hello").then().statusCode(200);
  }
  
  
  
  
  
  
  
  
  
  
  
}
