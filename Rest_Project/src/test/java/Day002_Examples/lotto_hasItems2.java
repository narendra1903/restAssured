package Day002_Examples;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;



public class lotto_hasItems2 {
	

	
	
 @Test
  public void VerifyData() {
	  
	 
	  //http://localhost:8080/lotto.json
	 
	 RestAssured.baseURI = "http://localhost:8080";
	  
	  ValidatableResponse response  = given()
              .contentType(ContentType.JSON)
              .when()
             . get("/lotto.json").then().
             body("lotto.winners.winnerId", hasItems(23, 54));
          
	 
  }
  
 

  
  
}
