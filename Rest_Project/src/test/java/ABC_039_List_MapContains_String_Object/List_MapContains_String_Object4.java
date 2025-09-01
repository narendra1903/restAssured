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

public class List_MapContains_String_Object4 
{
	
	@Test
	public void WeatherMessageBody()
	{
		
		
	 RestAssured.baseURI = "https://reqres.in";
	 RequestSpecification httpRequest = RestAssured.given()
			 .contentType(ContentType.JSON);
	 Response response = httpRequest.get("/api/unknown");
	 
	 int statusCode = response.getStatusCode();
	 System.out.println("statusCode     : " + statusCode);

	 String JSON = response.getBody().asString();
	 System.out.println("Response Body1 is =>  " + response.asString());
	 	 
     //io.restassured.path.json.JsonPath;
	 JsonPath j1 = response.jsonPath();
	 List<Map<String, Object>> Employee =   j1.given(JSON).getList("data"); 
	 
	 
		for (Map<String, Object> E1 : Employee) {
			
			System.out.println("id : "+E1.get("id"));
			System.out.println("name : "+E1.get("name"));
			System.out.println("year : "+E1.get("year"));
			System.out.println("color : "+E1.get("color"));
			System.out.println("pantone_value : "+E1.get("pantone_value"));
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
