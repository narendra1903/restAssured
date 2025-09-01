package Day025_More_Info;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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


public class T005_booksBetween5And15 {

	
	//https://www.toolsqa.com/rest-assured/deserialize-json-array-to-an-array/
	//https://www.toolsqa.com/rest-assured/deserialize-json-array/
	@JsonIgnoreProperties(ignoreUnknown = true)
	@Test
	public void findAll_AuthorAs() throws JsonParseException, JsonMappingException, IOException
	{
		RestAssured.baseURI = "http://localhost:8080";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/store.json");

		// First get the JsonPath object instance from the Response interface
		JsonPath j1 = response.jsonPath();
		String str=response.body().asString();
		
		   List<Map<String, ?>> books = JsonPath.with(str).
		get("store.book.findAll { book -> book.price >= 5 && book.price <= 15 }");
	        assertThat(books.size(), equalTo(3));

	        
	      //1st book verification
	         String author = (String) books.get(0).get("author");
	        assertThat(author, equalTo("Nigel Rees"));

	         Float price = (Float) books.get(0).get("price");
	        assertThat(price, equalTo(8.95F));
		
	        	
	        //2nd book verification
	        
	        String author1 = (String) books.get(1).get("author");
	        assertThat(author1, equalTo("Evelyn Waugh"));

	         Float price1 = (Float) books.get(1).get("price");
	        assertThat(price1, equalTo(12.99F));
	        
	        
	        
		
		
	}

}
