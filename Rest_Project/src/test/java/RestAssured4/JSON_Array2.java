package RestAssured4;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@JsonIgnoreProperties
public class JSON_Array2 {

	//https://facingissuesonit.com/2019/07/17/com-fasterxml-jackson-databind-exc-unrecognizedpropertyexception-unrecognized-field-xyz-class-abc-not-marked-as-ignorable-x-known-properties/
	//https://www.toolsqa.com/rest-assured/deserialize-json-array-to-an-array/
	//https://www.toolsqa.com/rest-assured/deserialize-json-array/
	@JsonIgnoreProperties(ignoreUnknown = true)
	@Test
	public void JsonPathUsage() //throws JsonParseException, JsonMappingException, IOException
	{
		RestAssured.baseURI = "http://localhost:8080";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/users.json");
		
		
		 //ResponseBody body = response.getBody();
		 

		 
		
		 
		 System.out.println("Response Code is: " + response.getStatusCode());
		 System.out.println("Response Body is: " + response.body().asString());
			
		 JsonPath j1 = response.jsonPath();
		 
			String str=response.body().asString();
			
			System.out.println("str is:"+str);
		
		System.out.println("Response data is: " + j1.getList("data"));

		// Read all the books as a List of String. Each item in the list
		// represent a book node in the REST service Response
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		
		List<Employee1> allEmployees = j1.getList("data", Employee1.class);
		  


		// Iterate over the list and print individual book item
		// Note that every book entry in the list will be complete Json object of book
		for(Employee1 emp : allEmployees)
		{
			System.out.println("employee_name: " + emp.employee_name);
			System.out.println("employee_salary: " + emp.employee_salary);
			System.out.println("employee_age: " + emp.employee_age);
			System.out.println("---------------------------");
		}
	}

}
