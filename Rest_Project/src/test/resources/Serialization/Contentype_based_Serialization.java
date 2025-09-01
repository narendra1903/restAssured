package Serialization;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Contentype_based_Serialization {
	
	
  @Test
  public void test5() {
	  
	  Message message = new Message();
	  message.setMessage("My messagee");
	 
	  Response res=RestAssured.given().
	         contentType("application/json").
	         body(message).
	  when().
	        post("/message");  
	  
	  res.prettyPrint();
	  
  }
  
  
  
  
}
