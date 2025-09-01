package ABC_040_Path_Parameters;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;


public class Path_Parameters3 {
//https://reqres.in/api/users?page=2
	
	@Test
	public void UserListResponseBody()
	{
		//Get RequestSpecifction Reference
		RequestSpecification requestSpec = RestAssured.given().log().all();
		
		//specify base URI & base path
		requestSpec.baseUri("https://simple-books-api.glitch.me");
		requestSpec.pathParam("bookingid", 1);
		requestSpec.basePath("/books/{bookingid}");
		
		//create/perform get request
		Response response = requestSpec.get();
		
		response.prettyPrint();
		
		
	}
}
