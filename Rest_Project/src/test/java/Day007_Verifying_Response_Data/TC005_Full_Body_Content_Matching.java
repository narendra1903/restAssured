package Day007_Verifying_Response_Data;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

//import java.util.concurrent.TimeUnit;
import static java.util.concurrent.TimeUnit.*;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class TC005_Full_Body_Content_Matching {

	@Test
	public void test01()
	{
        
	
		

		
		String expectedBody=
				RestAssured.get("http://localhost:8080/Sample5.json").
				asString();
		
		String expectedBody1=expectedBody;
		
		//Validating Full body
		get("http://localhost:8080/Sample5.json").then().
		assertThat().body(equalTo(expectedBody1));
		
		System.out.println(expectedBody1);
	}
	
	
	
	
}
