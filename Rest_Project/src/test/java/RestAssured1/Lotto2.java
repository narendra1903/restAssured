package RestAssured1;

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

public class Lotto2 
{
	
	//https://www.toolsqa.com/rest-assured/read-json-response-body-using-rest-assured/
	//https://jsonplaceholder.typicode.com/users
	
	@Test
	public void WeatherMessageBody()
	{
	 RestAssured.baseURI = "https://dummy.restapiexample.com";
	 RequestSpecification httpRequest = RestAssured.given();
	 Response response = httpRequest.get("/api/v1/employee/2");
	
	 ResponseBody body = response.getBody();
	 

	 
	 System.out.println("Response Body is: " + body.asString());
	 
	 System.out.println("Response Code is: " + response.getStatusCode());
	 
	 
	 
	//httpRequest.get("/lotto.json").then().body("lotto.lottoId", equalTo(5));
	 
	 /*
	JsonPath j1=response.jsonPath();
	

	System.out.println("Lotto id is :"+j1.get("lotto.lottoId"));
	System.out.println("winning-numbers are :"+j1.get("lotto.winning-numbers"));

	System.out.println("Lotto id is :"+j1.get("lotto.winners.winnerId"));

	List<Integer> l1=j1.getList("lotto.winners.winnerId");
	
	for(Integer str:l1)
	{
		System.out.println("lotto.winners.winnerId is : "+str);
	}
	
	httpRequest.get("/lotto.json").then().body("lotto.winners.winnerId", hasItems(23, 54));
	

	System.out.println("Lotto id is :"+j1.get("lotto.price"));

	 
	httpRequest.get("/lotto.json").then().body("lotto.price", is(12.12f));
	
	*/
	
	 
	 
	}
}
