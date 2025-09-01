package RestAssured5;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import io.restassured.path.json.JsonPath;

public class MapString_MapStringString2 
{
	
	@Test
	public void WeatherMessageBody()
	{
	 RestAssured.baseURI = "https://gorest.co.in";
	 RequestSpecification httpRequest = RestAssured.given()
			 .contentType(ContentType.JSON);

	 Response response = httpRequest.get("/public/v2/users");

	 String JSON = response.getBody().asString();
	 System.out.println("Response Body1 is =>  " + response.asString());
	 	 
	 //System.out.println("Response Body is =>  " + body);
	 
	 JsonPath j1 = response.jsonPath();
	
	 int statusCode = response.getStatusCode();
	 System.out.println("statusCode is :"+statusCode);
	 
	// Map<String,Map<String,String>> mp=new HashMap<>();
	
	 List<Map> books1=j1.given(JSON).getList(""); 
	 //List<Map<String,Object>> books1 =j1.given(JSON).getList(""); 
	 
	 System.out.println(books1.get(0).get("id"));
	 System.out.println(books1.get(0).get("name"));
	 System.out.println(books1.get(0).get("email"));
	 System.out.println(books1.get(0).get("gender"));
	 System.out.println(books1.get(0).get("status"));
	 System.out.println("_____________________________");
	 
	System.out.println();
	
	 System.out.println(books1.get(1).get("id"));
	 System.out.println(books1.get(1).get("name"));
	 System.out.println(books1.get(1).get("email"));
	 System.out.println(books1.get(1).get("gender"));
	 System.out.println(books1.get(1).get("status"));
	 
	
	 
	 
	}
}
