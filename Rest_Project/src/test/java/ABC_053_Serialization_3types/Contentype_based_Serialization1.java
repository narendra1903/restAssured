package ABC_053_Serialization_3types;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Contentype_based_Serialization1 {
	
	
  @Test
  public void test5() {
	  
	  RestAssured.port = 8080;
	  Message message = new Message();
	  message.setName("Sudhakar");
	  message.setJob( "QA");
	  
	  RestAssured.baseURI="https://reqres.in/api/users";
	  RestAssured.given().header("Content-type","application/json").
      contentType(ContentType.JSON).
      body(message).
      when().post().
      then().statusCode(201).log().all();
	  
	//  res
	  
	 // res.prettyPrint();
	  
  }
  
  
  
  
}
