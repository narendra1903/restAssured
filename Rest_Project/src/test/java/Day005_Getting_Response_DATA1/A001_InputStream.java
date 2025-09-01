package Day005_Getting_Response_DATA1;

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


import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;


public class A001_InputStream 
{
	
	//https://www.toolsqa.com/rest-assured/read-json-response-body-using-rest-assured/
	//https://jsonplaceholder.typicode.com/users
	
	@Test
	public void WeatherMessageBody() throws IOException
	{
	 RestAssured.baseURI = "http://localhost:8080";
	 RequestSpecification httpRequest = RestAssured.given();

	 InputStream stream = httpRequest.get("/lotto.json").asInputStream();
	
	System.out.println("______________________________");
	
	 String text = null;
	    try (Reader reader = new InputStreamReader(stream)) {
	        text = CharStreams.toString(reader);
	    }
	    
	    System.out.println(text);
	 
		
	    
	}
}
