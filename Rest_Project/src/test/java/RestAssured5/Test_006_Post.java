package RestAssured5;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.path.json.JsonPath;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import static org.hamcrest.Matchers.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Test_006_Post {
	
	public void Test1Post() throws FileNotFoundException, IOException
	{
	
	RestAssured.baseURI = "https://api.example.com";
	RestAssured.basePath = "/v1/users";  // Common path for all endpoints
	 String requestBody = "";
	 String token = "your_actual_bearer_token_here";
	 
     File file1 = new File("src/test/resources/sample1.pdf");
     File file2 = new File("src/test/resources/sample2.pdf");
	  
	  // Send POST request and get response
      Response response = RestAssured.given().log().all() // logs request details
          .header("Authorization", "Bearer" + token)
          .pathParam("userId", 123)
          .queryParam("sort", "asc")      // Query parameter
          .queryParam("filter", "active")  // Multiple query params
          .multiPart("file1", file1)        // First file (field name = file1)
          .multiPart("file2", file2)        // Second file (field name = file2)
          .contentType("application/json")
          .body(requestBody)
      .when()
          .post("/api/users/{userId}/items")
      .then()
      	   .log().all()
          .statusCode(200) // soft check
          .extract().response();
      
      String JSON = response.getBody().asString();
      
      response.contentType();
      response.getHeaders();
      response.getCookies();

      response.getSessionId();
      response.getStatusCode();
      response.getStatusLine();
      response.getTime();
      response.getTimeIn(null);
      
      response.asByteArray();
      response.asInputStream();
      response.asString();
      response.body();
      response.equals(JSON);
      response.prettyPeek();
      response.prettyPrint();
  
      
      

      
      
      //import java.util.concurrent.TimeUnit;
      long timeInSeconds = response.timeIn(TimeUnit.SECONDS);
      System.out.println("Response time in seconds: " + timeInSeconds + " s");
      Assert.assertTrue(response.time() < 3000, "Response took too long!");
      //This asserts that the response is under 3 seconds.
      
      long timeInMillis = response.time(); // ⏱️ in milliseconds
      System.out.println("Response time: " + timeInMillis + " ms");
      Assert.assertTrue(timeInMillis < 2000,
              "❌ Response took too long! Expected under 2000 ms but got " + timeInMillis + " ms");
      ////This asserts that the response is under 2000 milliseconds.
      
      
      // Get response as byte array
      byte[] fileBytes = response.asByteArray();
      
   

     

      // Define destination file
      String downloadPath = "downloads/report.pdf";
      try (FileOutputStream fos = new FileOutputStream(downloadPath)) {
          fos.write(fileBytes);
          System.out.println("✅ File downloaded successfully to: " + downloadPath);
      }
      
    

      
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
