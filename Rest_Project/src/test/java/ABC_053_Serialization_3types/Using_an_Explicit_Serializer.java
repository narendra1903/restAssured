package ABC_053_Serialization_3types;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;

public class Using_an_Explicit_Serializer {
	
	
  @Test
  public void test5() {
	  
	  Map<String, Object>  message = new HashMap<>();
	  message.put("name", "Ravi11");
	  message.put("job", "Testing11");

	  
	  RestAssured.baseURI="https://reqres.in/api/users";
	  
	  RestAssured.given()
	  .header("Content-type","application/json")
      .contentType(ContentType.JSON)
     . body(message, ObjectMapperType.GSON).
      when().
      when().post().
      then().statusCode(201).log().all();
	  
	  
	
	  
  }
  
  
  
  
}
