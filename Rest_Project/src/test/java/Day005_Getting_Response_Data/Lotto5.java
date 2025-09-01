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

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;


public class Lotto5 
{
	
	//https://www.toolsqa.com/rest-assured/read-json-response-body-using-rest-assured/
	//https://jsonplaceholder.typicode.com/users
	
	@Test
	public void WeatherMessageBody() throws IOException
	{
	 RestAssured.baseURI = "http://localhost:8080";
	 RequestSpecification httpRequest = RestAssured.given();
	 //Response response = httpRequest.get("/lotto.json");

	 String json = httpRequest.get("/lotto.json").asString();
	 
	 JsonPath jsonPath = new JsonPath(json).setRoot("lotto");
	 int lottoId = jsonPath.getInt("lottoId");
	
	 List<Integer> winnerIds = jsonPath.getList("winners.winnerId");
	 
	 
	 System.out.println(lottoId);
	 System.out.println(winnerIds);
	 
	 int lottoId1 = httpRequest.get("/lotto.json").path("lotto.lottoId");
	 
	 System.out.println(lottoId1);
	 
	 
	// int lottoId1 = from(json).getInt("lotto.lottoId");
	// List<Integer> winnerIds1 = from(json).get("lotto.winners.winnerId");
	 
	 /*
	 jsonPath.get("Path");
	 jsonPath.getList("Path");
	 jsonPath.getMap("Path");
	 jsonPath.getFloat("Path");
	 double price 				= jsonPath.getDouble("products[0].price");
	 jsonPath.getShort("Path");
	 jsonPath.getBoolean("Path");
	 int userId 				= jsonPath.getInt("users[0].id");
	 List<String> usernames 	= jsonPath.getList("users.username");
	 Object username 			= jsonPath.get("users[0].username");
	 jsonPath.getLong("Path");
	 String ProductName=j1.get("product");
	 
	 List<Map<String, Object>> Datas =   jsonPath.given(json).getList("dataseries.wind10m");
		for (Map<String, Object> E1 : Datas) {
			
			System.out.println("speed : "+E1.get("speed"));
			System.out.println("direction : "+E1.get("direction"));
			System.out.println("_____________________");			
		}*/
	    
	}
}
