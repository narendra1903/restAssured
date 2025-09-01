package ABC_039_List_MapContains_String_Object;

import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import io.restassured.path.json.JsonPath;

public class List_MapContains_String_Object5_Country 
{
	
	
	@Test
	public void WeatherMessageBody()
	{
		
		
	 RestAssured.baseURI = "http://localhost:8080";
	 RequestSpecification httpRequest = RestAssured.given()
			 .contentType(ContentType.JSON);
	 Response response = httpRequest.get("/All_Json/Country.json");
	 
	 int statusCode = response.getStatusCode();
	 System.out.println("statusCode     : " + statusCode);

	 String JSON = response.getBody().asString();
	 System.out.println("Response Body1 is =>  " + response.asString());
	 	 
     //io.restassured.path.json.JsonPath;
	 JsonPath j1 = response.jsonPath();
	 
	 List<Map<String, Object>> COUNTRIES =   j1.given(JSON).getList("Countries"); 
	 List<Map<String, Object>> DATAS =   j1.given(JSON).getList("Countries.Data"); 
	 
	 
		for(int i=0;i<COUNTRIES.size();i++)
		 {
			
			System.out.println("id : "+COUNTRIES.get(i).get("Country"));
			
				 System.out.println("id : "+DATAS.get(i).get("Capital"));
				 System.out.println("id : "+DATAS.get(i).get("minimum temp (Degree Celsius)"));
				 System.out.println("id : "+DATAS.get(i).get("maximum temp (Degree Celsius)"));
				 System.out.println("id : "+DATAS.get(i).get("Currency"));
				 
			System.out.println("__________________________");
		}
		
		
		  
		
		
		
		
		
		
	}
}
