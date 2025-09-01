package RestAssured4;

import java.io.IOException;
import java.util.List;

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


public class JSON_Book2 {

	
	//https://www.toolsqa.com/rest-assured/deserialize-json-array-to-an-array/
	//https://www.toolsqa.com/rest-assured/deserialize-json-array/
	@JsonIgnoreProperties(ignoreUnknown = true)
	@Test
	public void JsonPathUsage() //throws JsonParseException, JsonMappingException, IOException
	{
		RestAssured.baseURI = "http://localhost:8080";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/Books.json");

		// First get the JsonPath object instance from the Response interface
		JsonPath j1 = response.jsonPath();
		
		String str=response.body().asString();
		
		System.out.println("str is:"+str);
		System.out.println("Books are:"+j1.getList("books"));
		
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		
		   List<Book> allBooks = j1.getList("books", Book.class);
		    
		    
		    
		   // List<Book> allBooks = j1.getList("books", Book.class);

		// Iterate over the list and print individual book item
		// Note that every book entry in the list will be complete Json object of book
	for(Book book : allBooks)
		{
			System.out.println("isbn: " + book.isbn);
			System.out.println("title: " + book.title);
			System.out.println("---------------------------");
		}
	}

}
