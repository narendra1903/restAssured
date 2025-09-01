package Day026_JSON_Array;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.json.JSONArray;
import org.testng.annotations.Test;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonParseException;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class JSON_Book {
	

	
	//https://www.toolsqa.com/rest-assured/deserialize-json-array-to-an-array/
	//https://www.toolsqa.com/rest-assured/deserialize-json-array/
	@JsonIgnoreProperties(ignoreUnknown = true)
	@Test
	public void JsonPathUsage() throws JsonParseException, JsonMappingException, IOException
	{
		RestAssured.baseURI = "http://localhost:8080";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/Books.json");

		// First get the JsonPath object instance from the Response interface
		JsonPath j1 = response.jsonPath();
		
		String str=response.body().asString();
		
		//System.out.println("str is:"+str);
		System.out.println("Books are:"+j1.getList("books"));
		JSONArray JSONResponseBody = new   JSONArray(j1.getList("books"));
		
		
		
		
		//System.out.println(JSONResponseBody.getJSONArray(0));
		
		System.out.println(JSONResponseBody.getJSONObject(0).getString("title"));
		System.out.println(JSONResponseBody.getJSONObject(0).getString("isbn"));
		System.out.println(JSONResponseBody.getJSONObject(0).getString("subtitle"));
		System.out.println(JSONResponseBody.getJSONObject(0).getString("author"));
		System.out.println(JSONResponseBody.getJSONObject(0).getString("published"));
		System.out.println(JSONResponseBody.getJSONObject(0).getString("publisher"));
		System.out.println(JSONResponseBody.getJSONObject(0).getInt("pages"));
		System.out.println(JSONResponseBody.getJSONObject(0).getString("website"));
		
	
		
		
		
		
		
		//SONResponseBody.getJSONObject(1).getString("website");
		
		//List<String> l1=j1.getList("books");
		
		//ObjectMapper objectMapper = new ObjectMapper(); 
		//objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		//Book p = objectMapper.readValue(str, Book.class);
		//objectMapper.readValue(str, null);
		
		//@SuppressWarnings("unused")
		//List<Book> allBooks = j1.getList("books");
		 // List<Book> allBooks = (List<Book>) objectMapper.readValue(str, Book.class);
	    // System.out.println(".....value is :"+p.getAuthor());
	     //System.out.println(".....value is :"+p.getDescription());
		//Read more: https://javarevisited.blogspot.com/2017/10/jackson-json-parsing-error.html#ixzz7aANV3cc2
		  

		// Read all the books as a List of String. Each item in the list
		// represent a book node in the REST service Response
		  //  List<Book> allBooks = j1.getList("books", Book.class);
		    
		    
		    
		   // List<Book> allBooks = j1.getList("books", Book.class);

		// Iterate over the list and print individual book item
		// Note that every book entry in the list will be complete Json object of book
	/*for(Book book : allBooks)
		{
			System.out.println("Book: " + book.title);
		}*/
	}

}
