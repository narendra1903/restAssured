package ABC_046_Root_Path;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import static org.hamcrest.Matchers.equalTo;

import java.math.BigDecimal;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

public class rootpath2 {
	

	 
    @Test
	public void test1()
    {
   	//RestAssured.baseURI = "http://localhost:8080";
    	

   	given().
   	when().
    get("/something.json").
    then().
     root("x.y"). // You can also use the "root" method
     body("firstName", is("sudhakar")).
     body("lastName", is("thati")).
     body("age", is(43)).
     body("gender", is("male"));
   	
  	
  	
  	
  	
  	
   	 
    }
}

