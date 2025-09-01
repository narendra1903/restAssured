package ABC_033_Create_Post_Request_PayLoads_Multiple_Ways;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ExcelUtil.ExcelApiTest3;
import ExcelUtil.ExcelApiTest4;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class PostRequest 
{
	
	
	@Test(dataProvider="TC01_PostRequest_Data")
	public void RegistrationSuccessful1(String str)
	{		
		System.out.println(str);
		System.out.println("_____________________________");
		
		RestAssured.baseURI ="https://reqres.in";
		RequestSpecification request = RestAssured.given();
		Response response = null;
		
		request.body(str);
		request.contentType(ContentType.JSON);
		response = request.post("/api/users");
		
		int statusCode = response.getStatusCode();
		System.out.println("The status code recieved: " + statusCode);
		System.out.println("Response body: " + response.body().asString());
 	
	}
	
	
}
