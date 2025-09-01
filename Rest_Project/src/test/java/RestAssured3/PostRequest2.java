package RestAssured3;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ExcelUtil.ExcelApiTest3;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class PostRequest2 
{
	
	@Test(dataProvider="TC01_PostRequest_Data")
	public void RegistrationSuccessful1(String str)
	{		
		RestAssured.baseURI ="http://dummy.restapiexample.com/api/v1";
		RequestSpecification request = RestAssured.given();
		Response response = null;
		
		request.body(str);
		request.contentType(ContentType.JSON);
		response = request.post("/create");
		
		int statusCode = response.getStatusCode();
		System.out.println("The status code recieved: " + statusCode);
		System.out.println("Response body: " + response.body().asString());
 
	}
	
	
	
	
	@DataProvider (name = "TC01_PostRequest_Data")
    public static  Object[][] Authentication1() throws Exception{
		
		ExcelApiTest3 eat= new ExcelApiTest3();
        Object[][] testObjArray = eat.getTableArray("C://HTML Report//RestAPI//TC01_PostData.xls","Sheet1");
        // System.out.println(testObjArray.length);
          return (testObjArray); 
	}

	
	

	//https://techndeck.com/get-request-using-rest-assured/
	//http://dummy.restapiexample.com/api/v1/employees
	
}
