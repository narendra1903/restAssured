package Day007_Verifying_Response_Data;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

//import java.util.concurrent.TimeUnit;
import static java.util.concurrent.TimeUnit.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class TC005_ContentType {

	@Test
	public void test01()
	{
		
		RestAssured.baseURI="https://demoqa.com/BookStore/v1/Books";
		//RestAssured.basePath="api/users";
		
		RestAssured.given().log().all().
		get("").
		then().assertThat().contentType(ContentType.JSON);
		
	}
	
	
	@Test
	public void test02()
	{
		
		RestAssured.baseURI="http://localhost:8080/shopping.xml";
		//RestAssured.basePath="api/users";
		
		RestAssured.given().log().all().
		get("").
		then().assertThat().contentType(ContentType.XML);
		
	}
	
	
	
}
