package ABC_036_Lotto_Examples;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import static org.hamcrest.Matchers.equalTo;

import org.hamcrest.Matcher;

import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;



public class Price_is_12_12_F2 {
	

	
 @Test
  public void VerifyData() {
	  
	 
	  //http://localhost:8080/lotto.json
	 
	 RestAssured.baseURI = "http://localhost:8080";
	  
	  ValidatableResponse response  = given()
              .contentType(ContentType.JSON)
              .get("/products").then().assertThat().
              body(matchesJsonSchemaInClasspath("products-schema.json"));
          
	 
  }

private Matcher<?> matchesJsonSchemaInClasspath(String string) {
	// TODO Auto-generated method stub
	return null;
}
  
 


  
  
}
