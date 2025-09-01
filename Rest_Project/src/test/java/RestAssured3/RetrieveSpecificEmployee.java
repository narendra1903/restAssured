package RestAssured3;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RetrieveSpecificEmployee 
{
	@Test
	public void retrieveSpecificEmployee() {

		  String id = "23490";
		  RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/employee/" + id;
		  Response response = null;
		  
		  try {
			RequestSpecification request = RestAssured.given();

			response =request.get();
			
			 System.out.println("Response :" + response.asString());
			 System.out.println("Status Code :" + response.getStatusCode());
			 System.out.println("Does Reponse contains 'employee_salary'? :" 
			 + response.asString().contains("employee_salary"));

		} catch (Exception e) {e.printStackTrace();}

	}

}




//https://techndeck.com/get-request-using-rest-assured/
//http://dummy.restapiexample.com/api/v1/employees

	//https://reqres.in/api/users?page=2&id=5


