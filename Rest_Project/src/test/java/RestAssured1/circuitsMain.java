package  RestAssured1;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import  io.restassured.response.Response;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;




/*
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;



import  io.restassured.RestAssured;
import  io.restassured.response.Response;

import  org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

*/




import org.openqa.selenium.WebDriver;

import java.util.*;




 
public class circuitsMain
{
	
	
	@Test
	public void FirstExample()throws Exception {
		
		
		WebDriver driver;
		Response resp=RestAssured.get("http://ergast.com/api/f1/2017/circuits.json");
		
		
		String yourJson1 = resp.asString();
		System.out.println(yourJson1);
		String str1="SudhakarT";
		System.out.println("Response data  is :"+str1);

		String yourJson = "{\"key1\":\"val1\", \"key2\":\"val2\"}";
		JsonParser parser = new JsonParser();
		JsonElement element = parser.parse(yourJson);
		
		JsonObject obj = element.getAsJsonObject(); //since you know it's a JsonObject
		Set<Map.Entry<String, JsonElement>> entries = obj.entrySet();//will return members of your object
		
		for (Map.Entry<String, JsonElement> entry: entries) {
		    System.out.println(entry.getKey());
		    System.out.println(entry.getValue());
		    System.out.println("--------");
		}
		
		
		
		
		 
	
		
	}
		
}
		
		
	
		/*JSONObject obj = new JSONObject(json);
		List<String> keys = obj.getJsonObject("list").getKeys();
		foreach (String key : keys) {
		realm.createObjectFromRealm(InnerObject.class, obj.getJsonObject("list").getJsonObject(key);
		}*/
		
		
		
		
		/*
		
		 JSONParser parser = new JSONParser();
		 Object obj = parser.parse(jsonstring);
         JSONArray array = (JSONArray)obj;
         JSONObject jsonObject = (JSONObject)array.get(1);
		
		
		//JSONObject jsonObject = new JSONObject();
		Set keys = jsonObject.keySet();
	    Iterator a = keys.iterator();
	    while(a.hasNext()) {
	    	String key = (String)a.next();
	        // loop to get the dynamic key
	        String value = (String)jsonObject.get(key);
	        System.out.print("key : "+key);
	        System.out.println(" value :"+value);
	    }
	    */
	    
	    



		
		//List winnerIds = RestAssured.get("http://ergast.com/api/f1/2017/circuits.json").jsonPath().getList("lotto.winnders.winnerId");
		
		
		/*
		 Gson gson = new Gson();
		
        //Read the employee.json file
        BufferedReader br = new BufferedReader(  
                new FileReader("C:\\Users\\Sudhakar\\Desktop\\circuitId.json"));
        
        
        //convert the json to  Java object (Employee)
        MRData MRData1 = gson.fromJson(br, MRData.class);
		 
		 		 
         System.out.println("Employee Name    : "+MRData1.getXmlns());
       
*/
		
		
	
	
	

	
	
	



