package ABC_054_DeSerialization_3types;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Create_JSON_from_a_HashMap_Deserialization {
	
	
  @Test
  public void test5() {
	  
	  Map<String, Object>  message = new HashMap<>();
	  message.put("name", "Ravi");
	  message.put("job", "Testing");

	  
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
