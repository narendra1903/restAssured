package ABC_020_SerializationAndDeserialization_ObjectMapper;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.config.ObjectMapperConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import ABC_026_JSON_To_ClassObject_ObjectMapper_Deserialization.Employee;

//import org.codehaus.jackson.type.ObjectMapper

import org.junit.BeforeClass;


import static io.restassured.RestAssured.given;

public class MessageBean_Contentype_based_Serialization {
	
	
  @Test
  public void test5() throws JsonProcessingException {
	  
	  RestAssured.port = 8080;
	  Message message = new Message();
	  message.setName("Sudhakar");
	  message.setJob( "QA");
	  
	
	  String jsonString = new ObjectMapper().writeValueAsString(message);
	  System.out.println(jsonString);
	  
	  RestAssured.baseURI="https://reqres.in/api/users";
	ValidatableResponse res=  RestAssured.given().header("Content-type","application/json").
      contentType(ContentType.JSON).
      body(message).
      when().post().
      then().statusCode(201);//.log().all();
	  
	  String jsonString1=res.extract().asString();
	  
	  System.out.println(jsonString1);
	  
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		
		
		Message m11 = mapper.readValue(jsonString1, Message.class);
	  
	  
	  System.out.println("___________________");
	   System.out.println(m11.getJob());
	   System.out.println(m11.getName());
	   
	//  res
	  
	 // res.prettyPrint();
	  
  }
  
  
  
  
}
