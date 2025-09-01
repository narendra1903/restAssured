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

public class A008_bodyobj_contains_JsonPath2 
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
	
	System.out.println (bodyobj);
	System.out.println (bodyobj);
	
	Assert.assertEquals(bodyobj.contains("janet.weaver@reqres.in"),true,"my response contains email as janet.weaver@reqres.in ");
	
	    
	
	 JsonPath j1 = response.jsonPath();

	 
	 	List<String> l1=j1.get("data.email");
	 
	 	System.out.println(l1);
	 	
		List<Integer> l2=j1.get("data.id");
		 
	 	System.out.println(l2);
	 	
	 	
	 	String zeroth_Index_ID=j1.getString("data[0].id");
		String zeroth_Index_EmailID=j1.getString("data[0].email");
		
		System.out.println(zeroth_Index_ID);
		System.out.println(zeroth_Index_EmailID);
		
		
		List<String> EmailID014=j1.get("data[0,1,4].email");
		System.out.println(EmailID014);
		
		Map<String,Object> mp=j1.getMap("data[4]");
		System.out.println(mp);
		
		
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
}
