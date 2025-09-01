package ABC_034_RestAssured_API_Chaining;

import org.json.simple.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Test3_UpdateUser {
	
	
  @Test
  public void UpdateUser(ITestContext context) {
	  
	  
	  System.out.println("***************Update User************************");
	  
	  JSONObject jsonData = new JSONObject();
		jsonData.put("name", "Prachi6");
		jsonData.put("job", "QA6");
		
		String user_id1=(String) context.getSuite().getAttribute("user_id");
		
		RestAssured.baseURI="https://reqres.in/api/users/"+user_id1;
		RestAssured.given().log().all().header("Content-type","application/json").
      contentType(ContentType.JSON).
      body(jsonData.toJSONString()).
      when().put().
      then().statusCode(200).log().all();
  }
}
