package Day025_More_Info;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import java.io.IOException;
import java.math.BigDecimal;
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
import io.restassured.path.json.config.JsonPathConfig;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class T008_getFloatAndDoublesAsBigDecimal {

	
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
		
		final JsonPath using = j1.with(str).
				using(new JsonPathConfig(
						JsonPathConfig.NumberReturnType.BIG_DECIMAL));
		
        assertThat(using.<Map<String, Map>>get("store").size(), equalTo(2));

        final Map<String, Object> bicycle = using.<Map<String, Map>>
        get("store").get("bicycle");
        
        final String color = (String) bicycle.get("color");
        final BigDecimal price = (BigDecimal) bicycle.get("price");
        assertThat(color, equalTo("red"));
        assertThat(price, equalTo(new BigDecimal("19.95")));
	        
		
		
	}

}
