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

public class TC006_Other_Parts_of_Reponse0_ResponseAwareMatcher {

//https://github.com/rest-assured/rest-assured/blob/master/examples/rest-assured-itest-java/src/test/java/io/restassured/itest/java/ResponseAwareMatcherITest.java

	//{ "userId" : "some-id", "href" : "http://localhost:8080/some-id" }

	
public void test1()
{
	get("http://localhost:8080/Sample5.json").then().body("href", new ResponseAwareMatcher<Response>() {
        public Matcher<?> matcher(Response response) {
                return equalTo("http://localhost:8080/22" + response.path("userId"));
        }
});
	
	
	
	
	
	  
	
	
	
}
	
	
		
	


}



