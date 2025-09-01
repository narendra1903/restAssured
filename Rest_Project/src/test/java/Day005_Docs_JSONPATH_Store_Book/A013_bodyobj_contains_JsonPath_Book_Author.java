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

public class A013_bodyobj_contains_JsonPath_Book_Author 
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

	 //String name = System.console().readLine();
	 //String name="Nigel Rees";
	 //List<Map> books = j1.get("store.book.findAll "+"{"+" book -> book.author == " + name +"}");
	 //System.out.println(books);
	 
	        String author = "Herman Melville";
    final List<Map<String, ?>> books = JsonPath.with(bodyobj)
             .param("author", author)
             .get("store.book.findAll { book -> book.author == author }");
   
    System.out.println(books);
    
    
    String name = "Herman Melville";
    List<Map> books2 = JsonPath.with(bodyobj).param("name", name).get("store.book.findAll { book -> book.author == name }");
    System.out.println(books2);
    
    /*
    The JsonPath implementation of rest-assured uses 
    a Groovy shell to evaluate expressions so be careful 
    when injecting user input into the expression.
     For example avoid doing this:

    	 String name = System.console().readLine();
    	 List<Map> books = with(Object).get("store.book.findAll { book -> book.author == " + name + " }");
    	 
    	Instead use the param(java.lang.String, java.lang.Object) method like this:
    	 String name = System.console().readLine();
    	 List<Map> books = with(Object).param("name", name).get("store.book.findAll { book -> book.author == name }");
    */
    
	}
}
