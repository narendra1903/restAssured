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

public class List_MapContains_String_Object1 
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
	 
	 JsonPath j1 = response.jsonPath();
	 
	 System.out.println("Product        : " + j1.get("Ename"));
	 
	 String EmployeeName=j1.get("Ename");
	 
	 int statusCode = response.getStatusCode();
	 
	 List<Map<String, Object>> Employees =   j1.given(JSON).getList("dataseries");  
	
		for (Map<String, Object> Employee : Employees) {
			
			System.out.println("timepoint : "+Employee.get("timepoint"));
			System.out.println("cloudcover : "+Employee.get("cloudcover"));
			System.out.println("seeing : "+Employee.get("seeing"));
			System.out.println("transparency : "+Employee.get("transparency"));
			System.out.println("lifted_index : "+Employee.get("lifted_index"));
			System.out.println("rh2m : "+Employee.get("rh2m"));
			System.out.println("wind10m : "+Employee.get("wind10m"));
			System.out.println("temp2m : "+Employee.get("temp2m"));
			System.out.println("prec_type : "+Employee.get("prec_type"));
			System.out.println("__________________________");
		}
		
		
		
	 //http://localhost:8080/All_Json/Employees.json
	}
}
