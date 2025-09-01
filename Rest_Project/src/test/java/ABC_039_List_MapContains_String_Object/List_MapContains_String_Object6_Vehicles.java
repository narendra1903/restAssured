package ABC_039_List_MapContains_String_Object;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import io.restassured.path.json.JsonPath;

public class List_MapContains_String_Object6_Vehicles 
{
	
	@Test
	public void WeatherMessageBody()
	{
		
		
		
	 RestAssured.baseURI = "http://localhost:8080";
	 RequestSpecification httpRequest = RestAssured.given()
			 .contentType(ContentType.JSON);
	 Response response = httpRequest.get("/All_Json/Vehicles.json");
	 
	 int statusCode = response.getStatusCode();
	 System.out.println("statusCode     : " + statusCode);

	 String JSON = response.getBody().asString();
	// System.out.println("Response Body1 is =>  " + response.asString());
	 	 
     //io.restassured.path.json.JsonPath;
	 JsonPath j1 = response.jsonPath();
	 
	
	 
	 List<Map<String, Object>> RESULTS =   j1.given(JSON).getList("Results"); 
	 
 
	 String content = response.asString();
	 List<String> VEHICLETYPES = j1.from(content).getList("Results.VehicleTypes");
	 
	 
	 
	 //List<List<String>> VEHICLETYPES1 = j1.given(JSON).getList("Results.VehicleTypes");
	
	
	 
		for(int i=0;i<RESULTS.size();i++)
		 {
			
			System.out.println("id : "+RESULTS.get(i).get("Country"));
			System.out.println("id : "+RESULTS.get(i).get("Mfr_CommonName"));
			System.out.println("id : "+RESULTS.get(i).get("Mfr_ID"));
			System.out.println("id : "+RESULTS.get(i).get("Mfr_Name"));
			
			//System.out.println("id : "+VEHICLETYPES.get(i).size());
			//System.out.println("id : "+VEHICLETYPES.get(i));
		
			// List<Map<String,Object>> T1=j1.getList("Results.VehicleTypes");
			// List<List<String>> VEHICLETYPES = j1.given(JSON).getList("Results.VehicleTypes");
			
			 System.out.println("count : "+VEHICLETYPES.size());
			 String returendLastName = j1.from(content).getString("[0].IsPrimary");
			 System.out.println("IsPrimary : "+returendLastName);
			 //String returendLastName = from(j1).getString("[0].lastName");
			 
			System.out.println("__________________________");
			
		}
		
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
