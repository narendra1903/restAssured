package ABC_039_List_MapContains_String_Object;

import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import io.restassured.path.json.JsonPath;

public class List_MapContains_String_Object5_Batters 
{
	
	
	@Test
	public void WeatherMessageBody()
	{
		
		
	 RestAssured.baseURI = "http://localhost:8080";
	 RequestSpecification httpRequest = RestAssured.given()
			 .contentType(ContentType.JSON);
	 Response response = httpRequest.get("/All_Json/Batters.json");
	 
	 int statusCode = response.getStatusCode();
	 System.out.println("statusCode     : " + statusCode);

	 String JSON = response.getBody().asString();
	 System.out.println("Response Body1 is =>  " + response.asString());
	 	 
     //io.restassured.path.json.JsonPath;
	 JsonPath j1 = response.jsonPath();
	 List<Map<String, Object>> BATTERS =   j1.given(JSON).getList("batters.batter"); 
	 
	 
		for (Map<String, Object> B1 : BATTERS) {
			
			System.out.println("id : "+B1.get("id"));
			System.out.println("name : "+B1.get("type"));
			System.out.println("__________________________");
		}
		
		
		List<Map<String, Object>> TOPPINGS =   j1.given(JSON).getList("topping"); 
		for (Map<String, Object> T1 : TOPPINGS) {
			
			System.out.println("id : "+T1.get("id"));
			System.out.println("name : "+T1.get("type"));
			System.out.println("__________________________");
		}	  
		
		
		
		
		
		
	}
}
