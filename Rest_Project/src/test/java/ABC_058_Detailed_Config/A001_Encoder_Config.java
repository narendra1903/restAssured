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

public class A001_Encoder_Config {
	

	public void test1()
	{
	
	System.out.println("__________________________");
	

	
    RestAssured.config().encoderConfig(
      RestAssured.config().getEncoderConfig().defaultContentCharset("US-ASCII"));
    
    RestAssured.config().encoderConfig(
           RestAssured.config().getEncoderConfig().defaultContentCharset("UTF-8"));
    
    RestAssured.config().encoderConfig(
            RestAssured.config().getEncoderConfig().
            defaultCharsetForContentType("UTF-16", "application/xml"));
 
     
   
	
	}
	
	
	
	
	
  
}
