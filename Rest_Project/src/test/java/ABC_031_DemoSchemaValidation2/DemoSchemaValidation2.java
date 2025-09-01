package ABC_031_DemoSchemaValidation2;

import java.io.File;

import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

public class DemoSchemaValidation2 {

	//https://www.jsonschema.net/
	//https://www.jsonschema.net/app/schemas/0
	
	@Test
	public void testMethod()
	{
		String json = "{\r\n"
				+ "        \"id\": 2,\r\n"
				+ "        \"email\": \"janet.weaver@reqres.in\",\r\n"
				+ "        \"first_name\": \"Janet\",\r\n"
				+ "        \"last_name\": \"Weaver\"\r\n"
				+ "}";
		
		System.out.println(json);
		
	//	MatcherAssert.assertThat(json, JsonSchemaValidator.matchesJsonSchemaInClasspath("EmployeeSchema.json"));
	
		MatcherAssert.assertThat(json, JsonSchemaValidator.matchesJsonSchema(new File("C:\\Rest_Project\\src\\test\\java\\ABC_031_DemoSchemaValidation2\\Employee.Json")));
		
		
	}
}
