package Day007_Verifying_Response_Data;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

//import java.util.concurrent.TimeUnit;
import static java.util.concurrent.TimeUnit.*;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertTrue;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.startsWith;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.*;
import static io.restassured.matcher.ResponseAwareMatcherComposer.*;

public class TC006_Other_Parts_of_Reponse1_Lamda {

	
		
	
	
	






@Test
public void Test3()
{
	
	//{ "userId" : "some-id", "href" : "http://localhost:8080/some-id" }
	//Validate href some-id 
	
    // Define the base URL
    RestAssured.baseURI = "http://localhost:8080/Sample5.json";

    get("").then().
    body("href", response -> equalTo("http://localhost:8080/22" + response.path("userId")));
}















}



