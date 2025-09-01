package RestAssured5;

import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import io.restassured.path.json.JsonPath;

public class List_MapContains_String_Object 
{
	
	@Test
	public void WeatherMessageBody()
	{
	 RestAssured.baseURI = "http://localhost:8080";
	 RequestSpecification httpRequest = RestAssured.given()
			 .contentType(ContentType.JSON);

	 Response response = httpRequest.get("/circute2.json");

	 String JSON = response.getBody().asString();
	 System.out.println("Response Body1 is =>  " + response.asString());
	 	 
	 //System.out.println("Response Body is =>  " + body);
	 
	 JsonPath j1 = response.jsonPath();
	 System.out.println("Product        : " + j1.get("product"));
	
	 int statusCode = response.getStatusCode();
	 //List<Map<String, Object>> Employee =   j1.given(JSON).getList("dataseries");  
	 
	 List<Map<String, Object>> Datas =   j1.given(JSON).getList("dataseries.wind10m");
	 
		for (Map<String, Object> E1 : Datas) {
			
			System.out.println("speed : "+E1.get("speed"));
			System.out.println("direction : "+E1.get("direction"));
			System.out.println("_____________________");			
		}
		
		
		
	 //http://localhost:8080/All_Json/Employees.json
	}
}
