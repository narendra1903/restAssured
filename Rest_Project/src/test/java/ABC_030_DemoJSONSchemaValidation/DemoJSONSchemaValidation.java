package ABC_030_DemoJSONSchemaValidation;

import java.io.File;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;

public class DemoJSONSchemaValidation {


	@Test
	public void testMethod()
	{
		String requestPayload = "{\r\n"
				+ "    \"username\" : \"admin\",\r\n"
				+ "    \"password\" : \"password123\"\r\n"
				+ "}";
		
		System.out.println(requestPayload);
		
		RestAssured
			.given()
			.baseUri("https://restful-booker.herokuapp.com/auth")
			.contentType(ContentType.JSON)
			.body(requestPayload)
			
			.when()
				.post()
			.then()
				.assertThat()
				.statusCode(200)
				.body("token",Matchers.notNullValue())
				//.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("userschema.json"));
				.body(JsonSchemaValidator.matchesJsonSchema(new File("C:\\Rest_Project\\src\\test\\java\\ABC_030_DemoJSONSchemaValidation\\userschema.json")));
	}
}
