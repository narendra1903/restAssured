package ABC_003_Get_Post_Put_Patch_Delete;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Test_005_DeleteMethod {

	@Test
	public void test06()
	{
		
		//String user_id1=(String) context.getAttribute("user_id");
		
		//RestAssured.baseURI="https://reqres.in/api/users/"+user_id1;
		
		RestAssured.baseURI="https://reqres.in/api/users/212";
		RestAssured.given().
		when().
			delete().
		then().
			log().all().
			statusCode(204);
	}
			
}
