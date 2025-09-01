package ABC_003_Get_Post_Put_Patch_Delete;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Test_003_PutMethod {

	@Test
	public void test04()
	{
		JSONObject jsonData = new JSONObject();
		jsonData.put("name", "Sheetal");
		jsonData.put("job", "teacher");
		
		RestAssured.baseURI="https://reqres.in/api/users/212";
		RestAssured.given().header("Content-type","application/json").
        contentType(ContentType.JSON).
        body(jsonData.toJSONString()).
        when().put().
        then().statusCode(200).log().all();
	}
}
