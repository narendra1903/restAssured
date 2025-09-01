package Day005_Docs_JSONPATH_Store_Book;

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

public class A012_bodyobj_contains_JsonPath_Price_Range 
{
	
	//https://www.javadoc.io/doc/io.rest-assured/json-path/latest/io/restassured/path/json/JsonPath.html
	
	
	@Test
	public void WeatherMessageBody() throws IOException
	{
	 RestAssured.baseURI = "http://localhost:8080/store.json";
	 RequestSpecification https = RestAssured.given();
	// Response response = httpRequest.get("/2");
	 
	 Response response= https.request(Method.GET,"");

	// String JSON = response.getBody().asString();
	 
	// response.prettyPrint();
	
	ResponseBody body=response.body();
	String bodyobj=body.asString();
	
	System.out.println (bodyobj);
	System.out.println (bodyobj);
	
	
	 JsonPath j1 = response.jsonPath();
	 List<Map> books = j1.get("store.book.findAll { book -> book.price >= 5 && book.price <= 15 }");
	 
	 System.out.println(books);
	
	}
}
