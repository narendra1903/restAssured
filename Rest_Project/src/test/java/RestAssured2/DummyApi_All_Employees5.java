package RestAssured2;

import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import io.restassured.path.json.JsonPath;

public class DummyApi_All_Employees5 
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
	 List<Map<String, Object>> Employee =   j1.given(JSON).getList("dataseries");  
	 
	 
	 
	
		for (Map<String, Object> E1 : Employee) {
			
			System.out.println("timepoint : "+E1.get("timepoint"));
			System.out.println("cloudcover : "+E1.get("cloudcover"));
			System.out.println("seeing : "+E1.get("seeing"));
			System.out.println("transparency : "+E1.get("transparency"));
			System.out.println("lifted_index : "+E1.get("lifted_index"));
			System.out.println("rh2m : "+E1.get("rh2m"));
			System.out.println("wind10m : "+E1.get("wind10m"));
			System.out.println("temp2m : "+E1.get("temp2m"));
			System.out.println("prec_type : "+E1.get("prec_type"));
			System.out.println("__________________________");
		}
		
		
		
	 //http://localhost:8080/All_Json/Employees.json
	}
}
