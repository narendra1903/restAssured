package Day002_Examples;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import static org.hamcrest.Matchers.equalTo;

import java.math.BigDecimal;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

public class lotto_equalTo_Example1 {
	

	 
	
    @Test
	public void test1()
    {
   	//RestAssured.baseURI = "http://localhost:8080";
    	
   	given().when().
   	get("/lotto.json").then().body("lotto.lottoId", equalTo(5));
   	
  	given().when().
   	get("/lotto.json").then().body("lotto.winners.winnerId", hasItems(23, 54));
  	
  	given().when().
  	get("/price.json").then().body("price", is(12.12f));
  	
  	
  	/*given().when().
    config(RestAssured.config().jsonConfig(jsonConfig().numberReturnType(BIG_DECIMAL))).
    when().
    get("/price").
    then().
    body("price", is(new BigDecimal(12.12));*/
  	
  	
  	
   	 
    }
}

