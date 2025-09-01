package Day002_Examples;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.config.JsonConfig;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import static org.hamcrest.Matchers.equalTo;

import java.math.BigDecimal;

//import java.math.BigDecimal;

import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.path.json.config.JsonPathConfig;
import io.restassured.path.json.config.JsonPathConfig.NumberReturnType;
//import io.restassured.path.json.config.JsonPathConfig.NumberReturnType extends Enum<JsonPathConfig.NumberReturnType>;

import io.restassured.http.ContentType;
import io.restassured.path.json.config.JsonPathConfig.NumberReturnType;
import static io.restassured.config.RestAssuredConfig.newConfig;
import static io.restassured.config.JsonConfig.jsonConfig;
import io.restassured.path.json.config.*;
import static io.restassured.config.JsonConfig.jsonConfig;
//import java.lang.Enum  io.restassured.path.json.config.JsonPathConfig.NumberReturnType;

import io.restassured.path.json.config.JsonPathConfig.NumberReturnType;

import static io.restassured.path.json.config.JsonPathConfig.NumberReturnType;


//extends Enum<JsonPathConfig.NumberReturnType>;

//import java.lang.


public class Price_is_12_12_BigDecimal  {
	

	//  public static NumberReturnType BIG_DECIMAL;
 //private static final String BIG_DECIMAL = null;

//private static final String BIG_DECIMAL = null;

@Test
  public void VerifyData() {
	  
	 
	  //http://localhost:8080/lotto.json
	 
	 RestAssured.baseURI = "http://localhost:8080";
	 
    // RestAssured.config =   
   	    //  newConfig().jsonConfig(jsonConfig().numberReturnType(NumberReturnType.BIG_DECIMAL));
	  
	  ValidatableResponse response  = given().
			//config(RestAssured.config().jsonConfig(numberReturnType(BIG_DECIMAL))).
			//config(RestAssured.config). 
			  config(newConfig().jsonConfig(jsonConfig().numberReturnType(NumberReturnType.BIG_DECIMAL))).   
		when().
		        get("/lotto2.json").
		then().
		        body("price", is(new BigDecimal(12.12)));
		//body("price", is(new BigDecimal(12.1199999999999992184029906638897955417633056640625)));
		
		        
	  
	
	 
  }


  
 

  
  
}
