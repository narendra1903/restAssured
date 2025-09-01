package ABC_007_Query_Parameters;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;


public class QueryParameters_BDD_Style {


			@Test
		    public void testWithQueryParams() {
				
		        RestAssured.baseURI = "https://reqres.in/api";

		       ValidatableResponse response= RestAssured.given().log().all()
		            .queryParam("page", "2")
		            .queryParam("id", "5")
		        .when()
		            .get("/users")
		        .then()
		            .statusCode(200);
		       
		       System.out.println("_________________________________");
		       response.log().all();
		            //.body("responseBodyKey", equalTo("expectedValue"));
		    }

	
}
