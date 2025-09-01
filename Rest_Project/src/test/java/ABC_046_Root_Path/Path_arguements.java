package ABC_046_Root_Path;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.withArgs;
import static io.restassured.RestAssured.withNoArgs;

import io.restassured.RestAssured;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class Path_arguements {
	

	 
    @Test
	public void test1()
    {
         //https://simple-books-api.glitch.me/books/1
    //	RestAssured.baseURI = "https://simple-books-api.glitch.me";
    	
    	given().log().all().
    	when().
        get("/store.json").
        then().
        root("store.%s", withArgs("book")).
        body("category.size()", equalTo(4)).
        appendRoot("%s.%s", withArgs("author", "size()")).
        body(withNoArgs(), equalTo(4)).log().all();
    	
    	//https://reqres.in/api/users?page=2&id=5
    }
}

