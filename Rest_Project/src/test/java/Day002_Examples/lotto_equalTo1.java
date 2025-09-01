package Day002_Examples;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;



public class lotto_equalTo1 {
	

	
 @Test
  public void VerifyData() {
	  
	 
	 //http://localhost:8080/store
	  
	  ValidatableResponse response  = given()
              .contentType(ContentType.JSON).
              when()
              .get("/store.json").
       then().
       body("store.book.author.collect { it.length() }.sum()", lessThan(54));
          
	 
	  
  }
  
 
 

  
  
}
