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


public class T003_lastBookTitle2 {

	
	
	
	//https://www.toolsqa.com/rest-assured/deserialize-json-array-to-an-array/
	//https://www.toolsqa.com/rest-assured/deserialize-json-array/
	@JsonIgnoreProperties(ignoreUnknown = true)
	@Test
	public void JsonPathUsage() throws JsonParseException, JsonMappingException, IOException
	{
		RestAssured.baseURI = "http://localhost:8080";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/store.json");

		// First get the JsonPath object instance from the Response interface
		JsonPath j1 = response.jsonPath();
		
		String JSON=response.body().asString();
		
		
		final List<String> categories = new JsonPath(JSON).get("store.book.category");
        assertThat(categories.size(), equalTo(4));
        assertThat(categories, hasItems("reference", "fiction"));
		
        //firstBookCategory
        final String category = JsonPath.with(JSON).get("store.book[0].category");
        assertThat(category, equalTo("reference"));
        
        //lastBookTitle
        final String title = JsonPath.with(JSON).get("store.book[-1].title");
        assertThat(title, equalTo("The Lord of the Rings"));
		
        
        
        String author = "Herman Melville";
        final List<Map<String, ?>> books = JsonPath.with(JSON)
                .param("author", author)
                .get("store.book.findAll { book -> book.author == author }");
        assertThat(books.size(), equalTo(1));

        final String authorActual = (String) books.get(0).get("author");
        assertThat(authorActual, equalTo(author));
		
	}
	
	

}
