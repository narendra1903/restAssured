package ABC_003_Get_Post_Put_Patch_Delete;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;
//import junit.framework.Assert;

public class Test_001_GetMethod {

	@Test
	public void test01()
	{
		Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		
		response.prettyPrint();
		
		System.out.println("Response code:" + response.getStatusCode());
		System.out.println("Response body:" + response.getBody().asString());
		System.out.println("Response Time:" + response.getTime());
		System.out.println("Response Header:" + response.getHeader("Content-Type"));
		
	
		int ActualStatuscode = response.getStatusCode();
		
		Assert.assertEquals(200, ActualStatuscode);
		

		
	}

	
	
}
