package ABC_002;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.io.CharStreams;

import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Map;
import java.util.Map.Entry;

import io.restassured.RestAssured;
import io.restassured.http.Cookie;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.path.xml.XmlPath.CompatibilityMode;
import io.restassured.response.Response;
//import junit.framework.Assert;

public class Test_001_GetMethod2 {

	
	@Test
	public void test02() throws IOException
	{
		//given , when, then
		RestAssured.baseURI="https://reqres.in/api/users";
		
		Response response=
				
		RestAssured.given()
		.queryParam("page", "2")
		.when()
		.get()
		.then()
		.statusCode(200)
		.and().extract().response();
		
		
		response.prettyPrint();
		
		System.out.println("Response code:" + response.getStatusCode());
		System.out.println("Response getStatusLine:" + response.getStatusLine());
		System.out.println("Response body:" + response.getBody().asString());
		System.out.println("Response Time:" + response.getTime());
		System.out.println("Response Header:" + response.getHeader("Content-Type"));
		System.out.println("Response Session id:" + response.getSessionId());

		
		
		
	}
	
}
