package ABC_036_Lotto_Examples;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;



public class store2 {
	

	
 @Test
  public void VerifyData() {
	  
	 
	 //http://localhost:8080/store
	  
	  ValidatableResponse response  = given()
              .contentType(ContentType.JSON).
              when()
              .get("/store.json").
       then().
              body("store.book.findAll { it.price < 10 }.title", 
            		  hasItems("Sayings of the Century", "Moby Dick"));
          
	 
  }
  
 
 

  
  
}
