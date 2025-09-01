package ABC_047_Filters;
import io.restassured.RestAssured;
import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

import org.junit.jupiter.api.Test;



    // Custom filter implementation
    public class CustomFilter implements Filter {
  
		@Override
		public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec,
				FilterContext ctx) {
			  System.out.println("Request: " + requestSpec.getMethod() + " " + requestSpec.getURI());

	            // Proceed with the request
	            Response response = ctx.next(requestSpec, responseSpec);

	            // Log the response status code
	            System.out.println("Response Status Code: " + response.getStatusCode());

	            return response;
		}
    
}