package ABC_058_Detailed_Config;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.params.CoreConnectionPNames;
import org.testng.annotations.Test;
import org.json.simple.JSONObject;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.Response;

public class A006_JSON_Config {
	

	public void test1()
	{
	//RequestConfig requestConfig = RequestConfig.custom()
		 //   .setConnectTimeout(5000)
		  //  .setSocketTimeout(5000)
		  //  .build();


	RestAssuredConfig config1=RestAssuredConfig.config()
            .httpClient(HttpClientConfig.httpClientConfig()
                    .setParam("http.socket.timeout",1000)
                    .setParam("http.connection.timeout", 1000));


	//RestAssured.baseURI="https://reqres.in/api/users";
	RestAssured.given().config(config1).header("Content-type","application/json").
    contentType(ContentType.JSON).
    when().get("https://reqres.in/api/users").
    then().statusCode(200).log().all();
	
	System.out.println("__________________________");
	
	
	
	}
	
	
	
	@Test
	public void test2()
	{
		RestAssured.config = RestAssured.config().httpClient
				(HttpClientConfig.httpClientConfig()
			    .setParam("http.connection.timeout", 5000) // Connection Timeout
			    .setParam("http.socket.timeout", 5000)      // Socket Timeout
			    .setParam("http.connection-manager.timeout", 5000) // Connection Manager Timeout
			    .setParam("http.connection.stalecheck", false)); // Disable stale connection check

			// Then you can make your Rest Assured request
			Response response = RestAssured.given()
			    .when()
			    .get("https://reqres.in/api/users");

			// And you can assert on the response as needed
			response.then().assertThat().statusCode(200).log().all();
	}
	
	

	
	
	
	
	
  
}
