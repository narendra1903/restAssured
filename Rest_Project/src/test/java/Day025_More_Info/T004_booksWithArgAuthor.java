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


public class T004_booksWithArgAuthor {

	
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
		
		String author1 = "Herman Melville";
		
        final List<Map<String, ?>> books = j1.with(str)
                .param("author", author1)
                .get("store.book.findAll { book -> book.author == author }");
        assertThat(books.size(), equalTo(1));

        final String authorActual = (String) books.get(0).get("author");
        assertThat(authorActual, equalTo(author1));
		
		
		
		
	}

}
