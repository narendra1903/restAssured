package ABC_046_Root_Path;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import static org.hamcrest.Matchers.equalTo;

import java.math.BigDecimal;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

public class rootpath1 {
	
    @Test
	public void test1()
    {
   	//RestAssured.baseURI = "http://localhost:8080";
    	

   	given().
   	when().
    get("/something.json").
    then().
    body("x.y.firstName", is("sudhakar")).
    body("x.y.lastName", is("thati")).
    body("x.y.age", is(42)).
    body("x.y.gender", is("males"));
   	
  	
  	
  	
  	
  	
   	 
    }
}

