package Day005_Extracting_values_from_Response_after_validation;

import org.testng.annotations.Test;

import com.google.common.io.CharStreams;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
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


import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;


public class A004_extract_Path 
{
	
	//https://www.toolsqa.com/rest-assured/read-json-response-body-using-rest-assured/
	//https://jsonplaceholder.typicode.com/users
	
	//https://reqres.in/api/users?page=2
	
	@Test
	public void WeatherMessageBody() throws IOException
	{
	 //RestAssured.baseURI = "http://localhost:8080";
	 //RequestSpecification httpRequest = RestAssured.given();
	 
	 //String json = httpRequest.get("/myTitle.json").asString();
	 
	 String nextTitleLink =
			 given().
			         param("param_name", "param_value").
			 when().
			         get("/myTitle.json").
			 then().
			         contentType(ContentType.JSON).
			         body("title", equalTo("My Title")).
			 extract().
			         path("_links.next.href");

	 System.out.println(nextTitleLink);
	
	
	
	    
	}
}
