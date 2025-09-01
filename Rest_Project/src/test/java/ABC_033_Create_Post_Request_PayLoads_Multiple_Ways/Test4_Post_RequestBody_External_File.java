package ABC_033_Create_Post_Request_PayLoads_Multiple_Ways;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyExtractionOptions;
import io.restassured.response.ValidatableResponse;

public class Test4_Post_RequestBody_External_File {
	
  @Test
  public void External_File( ) throws FileNotFoundException
	{


	  //File f=new File(".\\body.json");
	  File f=new File("C:\\Rest_Project\\src\\test\\java\\ABC_033_Create_Post_Request_PayLoads_Multiple_Ways\\employees.json");
	  
	  FileReader fr=new FileReader(f);
	  JSONTokener jt=new JSONTokener(fr);
	  JSONObject data=new JSONObject(jt);
      
	    RestAssured
	        .given()
	            .header("Authorization","Bearer c005c96081fd4f9205d53b5f0e8d0aab4eac0c63ad282de7aeda1f2b2fd0bdc6")
	            .baseUri("https://gorest.co.in/public/v1/users/")
	            .contentType(ContentType.JSON)
	            .body(data.toString())
	            .log()
	            .body()
	       .when()
	           .post()
	        .then()
	            //.assertThat().statusCode(201)
	            .log().body();
		

	}
  
}
