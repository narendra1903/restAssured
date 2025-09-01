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

public class Path_Parameters {
	

	 
    @Test
	public void test1()
    {
         //https://simple-books-api.glitch.me/books/1
    	RestAssured.baseURI = "https://simple-books-api.glitch.me";
    	given().log().all().pathParam("bookingid", 1).
       	when().get("/books/{bookingid}").
        then().assertThat().statusCode(200).
        body("type",equalTo("fiction")).log().all();
    }
}

