package ABC_003_Get_Post_Put_Patch_Delete;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.Map;
import java.util.Map.Entry;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
//import junit.framework.Assert;
import io.restassured.specification.RequestSpecification;

public class Test_001_GetMethod3 {

	RequestSpecification requestSpec;
	Response response ;

	@BeforeTest
	public void RequestSpecInitilization()
	{
		
		//given , when, then
		RestAssured.baseURI="https://reqres.in/";
		RestAssured.basePath="api/users";
		requestSpec = RestAssured.given();
	}
	
	
	@Test
	public void Test1_get()
	{
		response = requestSpec.get();	
		response.prettyPrint();
		
		System.out.println("_______________________");
	}
	
	@Test
	public void Test2_Post()
	{
		JSONObject jsonData = new JSONObject();
		jsonData.put("name11", "Prachi");
		jsonData.put("job11", "QA");
		
		//requestSpec.log().all();
		
		response=requestSpec.body(jsonData.toJSONString()).
        when().post().
        then().statusCode(201).
        and().extract().response();
		
		response.prettyPrint();

	}
	
	
	
	
	
}
