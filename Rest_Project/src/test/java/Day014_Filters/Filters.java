package Day014_Filters;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.filter.Filter;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;



public class Filters {

    @Test
    public void useFilter() {
        // Register a custom filter
        RestAssured.filters(new CustomFilter());

        // Make a request
        Response response = RestAssured.get("https://jsonplaceholder.typicode.com/posts/1");

        // Assert the response or perform other operations
        response.then().statusCode(200);
        response.prettyPrint();
        
    }

  
    }
