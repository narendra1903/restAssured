package RestAssured2;

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

public class DummyApi_All_Employees7 
{
	
	@Test
	public void WeatherMessageBody()
	{
	 RestAssured.baseURI = "https://reqres.in";
	 RequestSpecification httpRequest = RestAssured.given()
			 .contentType(ContentType.JSON);

	 Response response = httpRequest.get("/api/users/2");

	 String JSON = response.getBody().asString();
	 System.out.println("Response Body1 is =>  " + response.asString());
	 	 
	 //System.out.println("Response Body is =>  " + body);
	 
	 JsonPath j1 = response.jsonPath();
	
	 int statusCode = response.getStatusCode();
	 System.out.println("statusCode is :"+statusCode);
	 
	 Map<String,Map> mp=new HashMap<>();
	 Map<String,Map> mp1=new HashMap<>();
	 
	 mp= j1.getMap("data");
	 mp1= j1.getMap("support");
	 
	 //j1.getMap(JSON);
	 //j1.getMap(JSON, null, null);
	 
	 
	 
	 System.out.println("data : "+mp);
	 System.out.println("support : "+mp1);	
	 
	 
	 System.out.println(mp.get("last_name"));
	 System.out.println(mp.get("id"));
	 System.out.println(mp.get("avatar"));
	 System.out.println(mp.get("first_name"));
	 System.out.println(mp.get("email"));
	 
	 
	 System.out.println(mp1.get("text"));
	 System.out.println(mp1.get("url"));
	 
	 
	}
}
