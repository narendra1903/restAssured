package RestAssured4;

import org.testng.annotations.Test;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import io.restassured.RestAssured;
import static org.hamcrest.Matchers.*;

import java.util.List;

public class SoapRequest6 
{
	
	
	

	 
	@Test
	public void post_test() {
		

		RestAssured.baseURI = "http://localhost:8080";
		Response response = null;
		RequestSpecification request = RestAssured.given();
		
		request.when().
	    get("/shopping").
	    then().
	    body("shopping.category.find { it.@type == 'groceries' }.item", 
	    		hasItems("Chocolate", "Coffee"));
		
		
	
		
	}
	/*
	public void post_test1() {
		
		
		 RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		 RequestSpecification httpRequest = RestAssured.given();
		 Response response = httpRequest.get("/Hyderabad");

		 ResponseBody body = response.getBody();
		 String res=body.asString();
		 List<String> groceries = from(res).getList("shopping.category.find { it.@type == 'groceries' }.item");
	
		
	}*/

	 
	 
}
