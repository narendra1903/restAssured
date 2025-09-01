package RestAssured3;

import org.json.simple.JSONObject;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostMethod 
{
	
	@Test
	public void RegistrationSuccessful1()
	{		
		RestAssured.baseURI ="http://dummy.restapiexample.com/api/v1";
		RequestSpecification request = RestAssured.given();

		JSONObject requestParams = new JSONObject();
		requestParams.put("name", "sudhakar");
		requestParams.put("salary", "50000");
		requestParams.put("age", "35");

		request.body(requestParams.toJSONString());
		Response response = request.post("/create");

		int statusCode = response.getStatusCode();
		System.out.println("The status code recieved: " + statusCode);

		System.out.println("Response body: " + response.body().asString());
	}
	
	
	
	
	
	
	
	
	
	
	//https://www.toolsqa.com/rest-assured/read-json-response-body-using-rest-assured/
	//https://jsonplaceholder.typicode.com/users
	//https://stackoverflow.com/questions/28982412/how-to-search-find-in-json-with-java/29084522
	
	

	 public void submitForm() {
	        RestAssured.baseURI = "https://www.example.com";
			RequestSpecification request = RestAssured.given();
	        
			JSONObject requestParams = new JSONObject();
	   
			requestParams.put("username", "user77@site.com");
			requestParams.put("password", "Pas5432177");
			
			
			request.body(requestParams.toJSONString());
			Response response = request.get("/login");
			
			int statusCode = response.getStatusCode();
			System.out.println("The status code recieved: " + statusCode);

			System.out.println("Response body: " + response.body().asString());
	 
	    }
	
	
	
	
}
