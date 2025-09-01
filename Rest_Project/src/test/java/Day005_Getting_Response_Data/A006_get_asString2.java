package Day005_Getting_Response_Data;

import org.testng.annotations.Test;

import com.google.common.io.CharStreams;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.eventFrom;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;


import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;


public class A006_get_asString2 
{
	
	//https://www.toolsqa.com/rest-assured/read-json-response-body-using-rest-assured/
	//https://jsonplaceholder.typicode.com/users
	
	@Test
	public void WeatherMessageBody() throws IOException
	{
	 RestAssured.baseURI = "http://localhost:8080";
	 RequestSpecification httpRequest = RestAssured.given();

	 String json = httpRequest.get("/lotto.json").asString();
	 System.out.println(json);
	 
	 JsonPath jsonPath = new JsonPath(json);
	 
	// Extract the integer value of "lottoId"
	 int lottoId = jsonPath.getInt("lotto.lottoId");

	 // Print the integer value of "lottoId"
	 System.out.println("Lotto ID: " + lottoId);
	 
	// int lottoId = from(json).getInt("lotto.lottoId");
	// List<Integer> winnerIds = from(json).get("lotto.winners.winnerId");
	  
	}
}
