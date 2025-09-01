package Day005_Extracting_values_from_Response_after_validation;

import org.testng.annotations.Test;

import com.google.common.io.CharStreams;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;


import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;


public class A006_extract_response1 
{
	
	//https://www.toolsqa.com/rest-assured/read-json-response-body-using-rest-assured/
	//https://jsonplaceholder.typicode.com/users
	
	@Test
	public void WeatherMessageBody() throws IOException
	{
	 RestAssured.baseURI = "https://reqres.in/api";
	 RestAssured.basePath="/users";
	 //RequestSpecification httpRequest = RestAssured.given();
	 
	 //String json = httpRequest.get("/myTitle.json").asString();
	 
		
		//header('Content-Type: application/json; charset=utf-8');
		
	 			String email = 
				given().log().all().  
				when().
			    get("/2").
				then().	
				extract().path("data.email");
			
	 
	 
	 			int id = 
				given().log().all().  
				when().
			    get("/2").
				then().	
				extract().path("data.id");
		
				System.out.println("____________________________");
				System.out.println( "EMAIL : "+email);
				System.out.println("ID :" +id);
				System.out.println("____________________________");
				
				
			Response response=given().log().all().  
			when().
		    get("/2").
			then().	
			extract().response();
			
			response.prettyPrint();
			
			 String EMAIL1 = response.path("data.email");
			 int id1 = response.path("data.id");
			 
			 System.out.println("email :"+EMAIL1);
			 System.out.println("id :"+id1);
			
		
	    
	}
}
