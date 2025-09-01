package Day016_RootPath;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.withArgs;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import static org.hamcrest.Matchers.equalTo;

import java.math.BigDecimal;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

public class rootpath4_Example2 {
	

	 
	
    @Test
	public void test1()
    {
   	//RestAssured.baseURI = "http://localhost:8080";
    	

   	given().
   	when().
    get("/store.json").
    then().
    root("store.book.category").
    body("size()", equalTo(4)).
    detachRoot("category").
    body("size()", equalTo(2));
  	
  	
  	
   	
   	
  	
   	 
    }
}

