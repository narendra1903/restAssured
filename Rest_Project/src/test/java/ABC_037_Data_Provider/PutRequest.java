package ABC_037_Data_Provider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ExcelUtil.ExcelApiTest3;
import ExcelUtil.ExcelApiTest4;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class PutRequest 
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
		response = request.put("/api/users/372");
		
		int statusCode = response.getStatusCode();
		System.out.println("The status code recieved: " + statusCode);
		System.out.println("Response body: " + response.body().asString());
 	
	}
	
	
	
	@DataProvider (name = "TC01_PostRequest_Data")
    public static  Object[][] Authentication1() throws Exception{
		
		ExcelApiTest4 eat= new ExcelApiTest4();
        Object[][] testObjArray = eat.getTableArray("TestData.xlsx","Sheet1");
         System.out.println(testObjArray.length);
          return (testObjArray); 
	}

	
	

	//https://techndeck.com/get-request-using-rest-assured/
	//http://dummy.restapiexample.com/api/v1/employees
	
}
