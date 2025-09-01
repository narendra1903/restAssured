package ABC_056_SerializationAndDeserialization_Using_Jackson;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
@JsonIgnoreProperties
public class Employee1_Serialization_Jackson {

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
		
		 System.out.println("Response Code is: " + response.getStatusCode());
		 System.out.println("Response Body is: " + response.body().asString());
			
		 String str=response.body().asString();
		 JsonPath j1 = response.jsonPath();
		 
			
			
			System.out.println("str is:"+str);
		
		System.out.println("Response data is: " + j1.given(str).getList("data"));

		// Read all the books as a List of String. Each item in the list
		// represent a book node in the REST service Response
		
	/*ObjectMapper mapper = new ObjectMapper();
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		
		List<Employee1> allEmployees = j1.getList("data", Employee1.class);
		  


		
		for(Employee1 emp : allEmployees)
		{
			System.out.println("employee_name: " + emp.employee_name);
			System.out.println("employee_salary: " + emp.employee_salary);
			System.out.println("employee_age: " + emp.employee_age);
			System.out.println("---------------------------");
		}
	}*/

	}	
}
