package ABC_034_RestAssured_API_Chaining;

import org.json.simple.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyExtractionOptions;
import io.restassured.response.ValidatableResponse;

public class Test1_CreateUser {
	
  @Test
  public void CreateUser(ITestContext context)
	{
		JSONObject jsonData = new JSONObject();
		jsonData.put("name", "Prachi5");
		jsonData.put("job", "QA5");
		
		RestAssured.baseURI="https://reqres.in/api/users";
		
		Response response=RestAssured.given().header("Content-type","application/json").
      contentType(ContentType.JSON).
      body(jsonData.toJSONString()).
      when().post().
      then().statusCode(201).log().all(). 
      extract().response();
		
		

		//System.out.println(" new user id is :"+id);
		
		// JsonPath jsonPathEvaluator = ((ResponseBodyExtractionOptions) response).jsonPath();
		
		//context.setAttribute("user_id", id);
		
		String id=response.jsonPath().getString("id");
		
		context.getSuite().setAttribute("user_id", id);

	}
  
}
