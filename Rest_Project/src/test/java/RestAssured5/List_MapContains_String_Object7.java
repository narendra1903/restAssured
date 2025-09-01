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

public class List_MapContains_String_Object7 
{
	
	@Test
	public void WeatherMessageBody()
	{
	 RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";
	 RequestSpecification httpRequest = RestAssured.given()
			 .contentType(ContentType.JSON);

	 Response response = httpRequest.get("/employees");

	 String JSON = response.getBody().asString();
	 System.out.println("Response Body1 is =>  " + response.asString());
	 
	 JsonPath j1 = response.jsonPath();
	 System.out.println("Status        : " + j1.get("status"));
	
	 int statusCode = response.getStatusCode();
	 List<Map<String, Object>> Employee =   j1.given(JSON).getList("data");  
	 
	    System.out.println(Employee);
		System.out.println(Employee.get(0).get("id"));
		System.out.println(Employee.get(0).get("employee_name"));
		System.out.println(Employee.get(0).get("employee_salary"));
		System.out.println(Employee.get(0).get("employee_age"));
		System.out.println(Employee.get(0).get("profile_image"));
	 
	 
	}
}
