package ABC_042_ResponseSpec_for_MultipleTests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import io.restassured.specification.SpecificationQuerier;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.anything;

public class ResponseSpecDemo2 {

	@BeforeTest
	public static ResponseSpecification CommonSpec()
	{
		
		ResponseSpecification commonResponseSpec = new ResponseSpecBuilder()
			    .expectStatusCode(200)
			    .expectContentType(ContentType.JSON)
			    .build();
		
		return commonResponseSpec;
		
		
	}
	
	
	@Test
	public  void test_without()
	{
		System.out.println("______________***************__________________");
		
		String  url="https://reqres.in/api/users?page=2";
	
		RestAssured.when().
		get(url).
		then().spec(CommonSpec()).log().all();
		
	
	}
	
	
@Test
	public  void test_with_parameters()
	{
	
		
		System.out.println("______________***************__________________");
		
		String  url="https://reqres.in/api/users";
	
		RestAssured.when().
		get(url).
		then().spec(CommonSpec()).log().all();
		//body("page",is(anything()));
		

		
		
	}
	
	
	
	
	
	
	
	
	
}
