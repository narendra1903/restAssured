package Day025_More_Info;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.LinkedHashSet;
import java.util.List;
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


public class T020_getNumericalValues {

	
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
		
		String str=response.body().asString();
		
		
		assertThat(j1.with(str).getDouble("store.book[0].price"), equalTo(8.95D));
        assertThat(j1.with(str).getFloat("store.book[0].price"), equalTo(8.95F));

        // The price is stored as an integer
        //assertThat(j1.with(str).getByte("store.book[1].price"), equalTo((byte) 12));
       // assertThat(j1.with(str).getShort("store.book[1].price"), equalTo((short) 12));
       // assertThat(j1.with(str).getInt("store.book[1].price"), equalTo(12));
      //  assertThat(j1.with(str).getLong("store.book[1].price"), equalTo(12L));

        // The atoms is stored as a long
        //assertThat(j1.with(str).getByte("store.bicycle.atoms"), equalTo((byte) Long.MAX_VALUE));
        //assertThat(j1.with(str).getShort("store.bicycle.atoms"), equalTo((short) Long.MAX_VALUE));
        //assertThat(j1.with(str).getInt("store.bicycle.atoms"), equalTo((int) Long.MAX_VALUE));
        //assertThat(j1.with(str).getLong("store.bicycle.atoms"), equalTo(Long.MAX_VALUE));
		
		
		
		
		
	}

}
