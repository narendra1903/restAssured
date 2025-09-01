package Day005_Getting_Response_Data;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.Matchers.equalTo;
public class QueryParameters4 
{
	
	

	//https://reqres.in/api/users?page=2&id=5
	
	//https://techndeck.com/get-request-using-rest-assured/
	//http://dummy.restapiexample.com/api/v1/employees
	

	
	@Test
	public void filterUser() {
 
		//http://localhost:8080
 
		try {
			
			RestAssured.baseURI = "http://localhost:8080";
			
			Response response =
					RestAssured.given().
			       // param("param_name", "param_value").
			when().
			        get("/All_Json/Sample1.json").
			then().
			       // contentType(JSON).
			        body("title", equalTo("My Title")).
			extract().response();

			String nextTitleLink = response.path("_links.next.href");
			String headerValue = response.header("headerName");
			
			System.out.println(nextTitleLink);
			System.out.println(headerValue);
			
		} catch (Exception e) {e.printStackTrace();}
 

	}
	

	
	
	
	
	
}
