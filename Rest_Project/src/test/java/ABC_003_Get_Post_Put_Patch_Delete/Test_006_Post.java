package ABC_003_Get_Post_Put_Patch_Delete;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class Test_006_Post {
	
	public void Test1Post()
	{
	
	 RestAssured.baseURI = "https://api.example.com";
	 String requestBody = "";
	  String token = "your_actual_bearer_token_here";
	  
	  // Send POST request and get response
      Response response = RestAssured.given()
          .header("Authorization", "Bearer " + token)
          .pathParam("userId", 123)
          .contentType("application/json")
          .body(requestBody)
      .when()
          .post("/api/users/{userId}/items")
      .then()
          .statusCode(200) // soft check
          .extract().response();
      
      // Convert to JsonPath for data extraction
      JsonPath jsonPath = response.jsonPath();
      
      String createdBy = jsonPath.getString("metadata.createdBy");
      Assert.assertEquals(createdBy, "admin", "CreatedBy value mismatch");
      
      // ✅ Extract items list
      List<Map<String, Object>> items = jsonPath.getList("items");
      Assert.assertEquals(items.size(), 2, "Items list size mismatch");

      // ✅ Extract item names and prices
      List<String> itemNames = jsonPath.getList("items.name");
      List<Integer> itemPrices = jsonPath.getList("items.price");

      // ✅ Assert that specific items are present
      Assert.assertTrue(itemNames.contains("Book"), "Book not found in item names");
      Assert.assertTrue(itemNames.contains("Pen"), "Pen not found in item names");

      // ✅ Assert all prices > 0
      for (int price : itemPrices) {
          Assert.assertTrue(price > 0, "Item price is not greater than 0: " + price);
      }

      // ✅ Timestamp non-null check
      String timestamp = jsonPath.getString("metadata.timestamp");
      Assert.assertNotNull(timestamp, "Timestamp is null");

      // Optional: print for debug
      System.out.println("Extracted item names: " + itemNames);
      System.out.println("Metadata timestamp: " + timestamp);
      
      

	}
			
}
