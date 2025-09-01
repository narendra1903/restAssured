package RestAssured2;

import java.util.ArrayList;
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

public class DummyApi_All_Employees8 
{
	
	@Test
	public void WeatherMessageBody()
	{
	 RestAssured.baseURI = "http://localhost:8080";
	 RequestSpecification httpRequest = RestAssured.given()
			 .contentType(ContentType.JSON);

	 Response response = httpRequest.get("/store.json");

	 //String JSON = response.getBody().asString();
	 //System.out.println("Response Body1 is =>  " + response.asString());
	 	 
	
	 JsonPath j1 = response.jsonPath();
	
	 int statusCode = response.getStatusCode();
	 System.out.println("statusCode is :"+statusCode);
	 
	 List<Object> l1=new ArrayList<Object>();
	 l1=j1.getList("store.book.category");
	 System.out.println(l1);
	 
	 List<String> l2=new ArrayList<String>();
	 l2=j1.getList("store.book.category");
	 System.out.println(l2);
	 
	 List<Object> l3=new ArrayList<Object>();
	 l3.add("Hai");
	 l3.add(1);
	 System.out.println(l3);
	 
	 
	 
	 
	}
}
