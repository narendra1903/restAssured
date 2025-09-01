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
import org.testng.asserts.Assertion;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.testng.Assert; 

public class A006_extract_response2 
{
	
	//https://www.toolsqa.com/rest-assured/read-json-response-body-using-rest-assured/
	//https://jsonplaceholder.typicode.com/users
	
	//https://reqres.in/api/users?page=2
	
	//https://www.youtube.com/watch?v=34Gnv4LY7Wg&list=PLAkEcrdilZ4nKszUU0AriCE9CP0VRjeVR&index=9
	
	@Test
	public void WeatherMessageBody() throws IOException
	{
	 RestAssured.baseURI = "https://reqres.in/api/users";
	 RequestSpecification https = RestAssured.given();
	// Response response = httpRequest.get("/2");
	 
	 Response response= https.request(Method.GET,"/2");

	 String EMAIL = response.path("data.email");
	 int id = response.path("data.id");
	 
	 System.out.println("email :"+EMAIL);
	 System.out.println("id :"+id);
	 response.prettyPrint();
	
	
	
	 
	}
}
