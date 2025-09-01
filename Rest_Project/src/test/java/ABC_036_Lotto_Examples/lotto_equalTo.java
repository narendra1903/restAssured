package ABC_036_Lotto_Examples;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;



public class lotto_equalTo {
	

	
 @Test
  public void VerifyData() {
	  
	 
	  //http://localhost:8080/lotto1.json
	 
    // RestAssured.baseURI = "http://localhost:8080";
	  
	  ValidatableResponse response  = given()
              .contentType(ContentType.JSON)
              .when()
             . get("/lotto.json").then().body("lotto.lottoId", equalTo(5));
          
	 
  }
 
  
 

  
  
}
