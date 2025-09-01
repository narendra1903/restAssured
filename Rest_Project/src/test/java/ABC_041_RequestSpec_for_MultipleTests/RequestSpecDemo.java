package ABC_041_RequestSpec_for_MultipleTests;

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


public class RequestSpecDemo {

	@BeforeTest
	public static RequestSpecification getCommonSpec()
	{
		//Get Request Specification for the given request
		RequestSpecification requestSpec = RestAssured.given().log().all();
		
		
		RequestSpecBuilder builder=new RequestSpecBuilder();

		//specify url
		builder.setBaseUri("https://reqres.in");
		builder.setBasePath("/api/users");
		
		RequestSpecification rs=builder.build();
		
		return rs;
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
