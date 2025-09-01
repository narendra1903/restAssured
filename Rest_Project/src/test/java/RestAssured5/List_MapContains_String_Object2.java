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

public class List_MapContains_String_Object2 
{
	
	@Test
	public void WeatherMessageBody()
	{
	 RestAssured.baseURI = "http://localhost:8080";
	 RequestSpecification httpRequest = RestAssured.given()
			 .contentType(ContentType.JSON);

	 Response response = httpRequest.get("/All_Json/Employees.json");

	 String JSON = response.getBody().asString();
	 System.out.println("Response Body1 is =>  " + response.asString());
	 	 
	 //System.out.println("Response Body is =>  " + body);
	 
	 JsonPath j1 = response.jsonPath();
	 System.out.println("Status        : " + j1.get("status"));
	
	 int statusCode = response.getStatusCode();
	 List<Map<String, Object>> Employee =   j1.given(JSON).getList("data");  
	 
	   /* System.out.println(Employee);
		System.out.println(Employee.get(0).get("id"));
		System.out.println(Employee.get(0).get("employee_name"));
		System.out.println(Employee.get(0).get("employee_salary"));
		System.out.println(Employee.get(0).get("employee_age"));
		System.out.println(Employee.get(0).get("profile_image"));*/
	
		for (Map<String, Object> E1 : Employee) {
			
			System.out.println("id : "+E1.get("id"));
			System.out.println("employee_name : "+E1.get("employee_name"));
			System.out.println("employee_salary : "+E1.get("employee_salary"));
			System.out.println("employee_age : "+E1.get("employee_age"));
			System.out.println("profile_image : "+E1.get("profile_image"));
			System.out.println("__________________________");
		}
		
		
		
	 //http://localhost:8080/All_Json/Employees.json
	}
}
