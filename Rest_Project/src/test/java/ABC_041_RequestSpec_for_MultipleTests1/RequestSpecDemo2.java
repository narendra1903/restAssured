package ABC_041_RequestSpec_for_MultipleTests1;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;


public class RequestSpecDemo2 {

	@BeforeTest
	public static RequestSpecification getCommonSpec()
	{
		
		RequestSpecification req = new RequestSpecBuilder()
				    .setBaseUri("https://reqres.in")
				    .setBasePath("/api/users")
				    .addHeader("Content-Type", "application/json")
				    .build();
		
			return req;

	}
	
	
	@Test
	public  void test_without_parameters()
	{
		System.out.println("______________***************__________________");
		
		Response response=
				RestAssured.given().spec(getCommonSpec()).when().get();
		
		response.getBody().prettyPrint();
	}
	
	
	@Test
	public  void test_with_parameters()
	{
		Response response=
				RestAssured.given().spec(getCommonSpec()).
				queryParam("page", "2").
				when().get();
		
		response.getBody().prettyPrint();
	}
	
	
	
	
	
	
	
	
	
}
