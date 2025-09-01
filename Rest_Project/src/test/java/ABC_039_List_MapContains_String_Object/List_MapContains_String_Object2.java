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

public class List_MapContains_String_Object2 
{
	
	@Test
	public void WeatherMessageBody()
	{
	 RestAssured.baseURI = "http://localhost:8080";
	 RequestSpecification httpRequest = RestAssured.given()
			 .contentType(ContentType.JSON);
	 Response response = httpRequest.get("/All_Json/Employees.json");
	 
	 int statusCode = response.getStatusCode();
	 System.out.println("statusCode     : " + statusCode);

	 String JSON = response.getBody().asString();
	 System.out.println("Response Body1 is =>  " + response.asString());
	 	 
     //io.restassured.path.json.JsonPath;
	 JsonPath j1 = response.jsonPath();
	 List<Map<String, Object>> Employee =   j1.given(JSON).getList("data"); 
	 
	 
		for (Map<String, Object> E1 : Employee) {
			
			System.out.println("id : "+E1.get("id"));
			System.out.println("employee_name : "+E1.get("employee_name"));
			System.out.println("employee_salary : "+E1.get("employee_salary"));
			System.out.println("employee_age : "+E1.get("employee_age"));
			System.out.println("profile_image : "+E1.get("profile_image"));
			System.out.println("__________________________");
		}
		
		   /* System.out.println(Employee);
			System.out.println(Employee.get(0).get("id"));
			System.out.println(Employee.get(0).get("employee_name"));
			System.out.println(Employee.get(0).get("employee_salary"));
			System.out.println(Employee.get(0).get("employee_age"));
			System.out.println(Employee.get(0).get("profile_image"));*/
		
	 //http://localhost:8080/All_Json/Employees.json
		
		//https://opensource.adobe.com/Spry/samples/data_region/JSONDataSetSample.html
	}
}
