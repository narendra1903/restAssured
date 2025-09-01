package Day016_RootPath;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.CoreMatchers.equalTo;

public class QueryParameters2 
{
	
	//https://reqres.in/api/users?page=2&id=5
	
	//https://techndeck.com/get-request-using-rest-assured/
	//http://dummy.restapiexample.com/api/v1/employees
	

	
	
 
	
		 @Test
		    public void verifyQueryParam() {
		 
		        String endpoint = "https://reqres.in/api/";
		 
		        // Given
		        RestAssured.given().log().all()
		                .queryParam("page", "2")
		 
		                // When
		                .when()
		                .get(endpoint + "users/")
		 
		                // Then
		                .then()
		 
		                // To verify the response body
		                .body("page", equalTo(2))
		                .body("per_page", equalTo(6))
		                .body("total_pages", equalTo(2));
		 
		    

	}
	

	
	
	
	
	
}
