package Day005_Getting_Response_Data;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;
import java.util.List;


import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;



public class Parameters 
{
	
	//https://www.toolsqa.com/rest-assured/read-json-response-body-using-rest-assured/
	//https://jsonplaceholder.typicode.com/users
	
	@Test
	public void WeatherMessageBody()
	{
	 RestAssured.baseURI = "http://localhost:8080";
	 //RequestSpecification httpRequest = RestAssured.given();
	 //Response response = httpRequest.get("/lotto.json");
	 
	 RestAssured.given().
     param("param1", "value1").
     param("param2", "value2").
     when().
     get("/something").prettyPrint();
	 
	}
}
