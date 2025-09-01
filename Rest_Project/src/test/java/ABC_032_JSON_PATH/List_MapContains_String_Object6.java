package ABC_032_JSON_PATH;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import io.restassured.path.json.JsonPath;

public class List_MapContains_String_Object6 
{
	
	@Test
	public void WeatherMessageBody()
	{
	 RestAssured.baseURI = "http://localhost:8080";
	 RequestSpecification httpRequest = RestAssured.given()
			 .contentType(ContentType.JSON);

	 Response response = httpRequest.get("/lotto.json");

	 String JSON = response.getBody().asString();
	 System.out.println("Response Body1 is =>  " + response.asString());
	 	 
	 //System.out.println("Response Body is =>  " + body);
	 JsonPath j1 = response.jsonPath();
	
	 int statusCode = response.getStatusCode();
	 System.out.println("statusCode is :"+statusCode);
	 
	
	 Integer str=j1.get("lotto.lottoId");
	 Float f1 =j1.getFloat("lotto.price");
	 System.out.println(str);
	 System.out.println(f1);
	 
	 List<Object> l1=new ArrayList<>();
	 l1=j1.getList("lotto.winning-numbers");
	 System.out.println(l1);
	 
	 System.out.println(j1.getList("lotto.winners"));
	 List<Map<String,Object>> T1=j1.getList("lotto.winners");
	
	 for(int i=0;i<T1.size();i++)
	 {
	 System.out.println(T1.get(i).get("winnerId"));
	 System.out.println(T1.get(i).get("numbers"));
	 System.out.println("___________________________");
	 }
	 	 
	}
}
