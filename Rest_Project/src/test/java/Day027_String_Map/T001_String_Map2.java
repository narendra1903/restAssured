package Day027_String_Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;
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


public class T001_String_Map2 {

	//https://mixedanalytics.com/blog/list-actually-free-open-no-auth-needed-apis/
	//https://www.toolsqa.com/rest-assured/deserialize-json-array-to-an-array/
	//https://www.toolsqa.com/rest-assured/deserialize-json-array/
	@JsonIgnoreProperties(ignoreUnknown = true)
	@Test
	public void findAll_AuthorAs() throws JsonParseException, JsonMappingException, IOException
	{
		RestAssured.baseURI = "http://www.7timer.info";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/bin/api.pl?lon=113.17&lat=23.09&product=astro&output=json");

		// First get the JsonPath object instance from the Response interface
		JsonPath j1 = response.jsonPath();
		String JSON=response.body().asString();
		
		//System.out.println(JSON);
		
		//JSONObject jObj = new JSONObject(str);
		
		
			j1.given(JSON).get("dataseries");
		
		
			  List<Map<String, Object>> books =   j1.given(JSON).getList("dataseries");                           
			 //JsonPath.with(JSON)
		                //.param("author", author)
		                //.get("store.book.findAll { book -> book.author == author }");
			  
		System.out.println(books.get(0).get("timepoint"));
		System.out.println(books.get(0).get("cloudcover"));
		System.out.println(books.get(0).get("seeing"));
		System.out.println(books.get(0).get("wind10m"));
		//System.out.println(books.get(0).get("temp2m"));
		//System.out.println(books.get(0).get("prec_type"));
		
		//@SuppressWarnings("unchecked")
		Map<String, Object> data=(Map<String, Object>) books.get(0).get("wind10m");
		System.out.println(data.get("direction"));
		System.out.println(data.get("speed"));
	}

}
