package Day002_Examples;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;



public class Price_is_12_12_F {
	

	
 @Test
  public void VerifyData() {
	  
	 
	  //http://localhost:8080/lotto.json
	 
	 RestAssured.baseURI = "http://localhost:8080";
	  
	  ValidatableResponse response  = given()
              .contentType(ContentType.JSON)
              .when()
             . get("/store.json").
             then().
             body("store.bicycle.price", is(19.95f));
          
	 
  }
 
 
  
 

  
  
}
