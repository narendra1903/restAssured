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


public class T001_String_Map {
	

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
		String str=response.body().asString();
		
		System.out.println(str);
		
		
		
		//System.out.println("Books are:"+j1.getList("books"));
		JSONArray JSONResponseBody = new   JSONArray(j1.given(str).getList("dataseries"));
		
		
		
		//System.out.println(JSONResponseBody.getJSONArray(0));
		
		System.out.println(JSONResponseBody.getJSONObject(0).getInt("timepoint"));
		System.out.println(JSONResponseBody.getJSONObject(0).getInt("cloudcover"));
		System.out.println(JSONResponseBody.getJSONObject(0).getInt("seeing"));
		//System.out.println(JSONResponseBody.getJSONObject(0).getString("wind10m"));
		
		JSONArray jsonArray = (JSONArray) j1.get("contact");
		
		
		
		
	}

}
