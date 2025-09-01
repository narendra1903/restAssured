package Day002_Examples;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;



public class shopping_XML2 {
	

	
 @Test
  public void VerifyData() {
	  
	 
	 //http://localhost:8080/shopping.xml
	  
	  ValidatableResponse response  = given()
              .contentType(ContentType.XML).
              when().
              get("/shopping.xml").
       then().
              body("**.find { it.@type == 'groceries' }", hasItems("Chocolate", "Coffee"));
          
	 
  }
  
 

 
  
  
}
