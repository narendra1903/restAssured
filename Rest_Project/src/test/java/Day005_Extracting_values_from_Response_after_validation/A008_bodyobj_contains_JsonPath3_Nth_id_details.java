package Day005_Extracting_values_from_Response_after_validation;

import org.testng.annotations.Test;

import com.google.common.io.CharStreams;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
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

import org.testng.asserts.Assertion;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.testng.Assert; 

public class A008_bodyobj_contains_JsonPath3_Nth_id_details 
{
	
	//https://www.toolsqa.com/rest-assured/read-json-response-body-using-rest-assured/
	//https://jsonplaceholder.typicode.com/users
	
	//https://reqres.in/api/users?page=2
	
	//https://www.youtube.com/watch?v=34Gnv4LY7Wg&list=PLAkEcrdilZ4nKszUU0AriCE9CP0VRjeVR&index=9
	
	@Test
	public void WeatherMessageBody() throws IOException
	{
	 RestAssured.baseURI = "https://reqres.in/api/users?page=2";
	 RequestSpecification https = RestAssured.given();
	// Response response = httpRequest.get("/2");
	 
	 
	 
	 Response response= https.request(Method.GET,"");

	// String JSON = response.getBody().asString();
	 
	 response.prettyPrint();
	
	ResponseBody body=response.body();
	String bodyobj=body.asString();
	
	//System.out.println (bodyobj);
	
	    
	
	 JsonPath j1 = response.jsonPath();

	 
	
// Get first record index details	 
	 List<Map<String, Object>> Records =   j1.given(bodyobj).getList("data");  
	 
	    //System.out.println(Records);
		//System.out.println(Records.get(0).get("id"));
		//System.out.println(Records.get(0).get("email"));
		//System.out.println(Records.get(0).get("first_name"));
		//System.out.println(Records.get(0).get("last_name"));
		//System.out.println(Records.get(0).get("avatar"));
		
	 	System.out.println(Records);
	 	
		System.out.println("_________________________________");
		
		
		for(int i=0;i<Records.size();i++)
		{
			System.out.println(Records.get(i).get("last_name"));
			
			if(Records.get(i).get("last_name").equals("Weaver"))
			{
				System.out.println(Records.get(i).get("id"));
				System.out.println(Records.get(i).get("email"));
				System.out.println(Records.get(i).get("first_name"));
				System.out.println(Records.get(i).get("last_name"));
				System.out.println(Records.get(i).get("avatar"));
				break;
			}
		}
	 
	 
	}
	      

		
		
		
	// jsonpath - slice approach

	// $['data'][*].id

	// $['data'][*].email

	// $['data'][0].email
	// $['data'][0].id

	// $['data'][0,1,4].id
		
	//	$.data[?(@,id == 4)]
	//		$ data[?(@,id > 4 )]
	 
	 //https://www.youtube.com/watch?v=34Gnv4LY7Wg&list=PLAkEcrdilZ4nKszUU0AriCE9CP0VRjeVR&index=9
	 
		/*
		Here are a few common JSONPath expressions:

			$.key: The root element of the JSON object with the specified key.
			$..key: Any element in the JSON object with the specified key.
			$.key1.key2: Nested JSON object traversal.
			$[index]: Array index access.
	*/
	}

