package ABC_034_RestAssured_API_Chaining;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Test4_DeleteUser {
	
	
  @Test
  public void DeleteUser(ITestContext context) {
	  
	  
	  System.out.println("*****************Delete User**********************");
	  
		String user_id1=(String) context.getSuite().getAttribute("user_id");
		
		RestAssured.baseURI="https://reqres.in/api/users/"+user_id1;
		RestAssured.given().log().all().
		when().
			delete().
		then().
			log().all().
			statusCode(204);
  }
}
