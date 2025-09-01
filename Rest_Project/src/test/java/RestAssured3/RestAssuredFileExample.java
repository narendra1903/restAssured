package RestAssured3;



import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Assert;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

import static io.restassured.RestAssured.given;

public class RestAssuredFileExample {
    public static void main(String[] args) {
        try {
            // Step 1: Read the JSON file as a string
            String filePath = "./circute3.json";  // Specify the correct path
            String jsonPayload = new String(Files.readAllBytes(Paths.get(filePath)));

            JsonPath J2 = new JsonPath(jsonPayload);
            String Request_id=J2.get("id");
            String Request_name=J2.get("name");
            String Request_createdAt= J2.get("createdAt");
            Integer Request_year=J2.getInt("data.year");
            Float Request_price=J2.getFloat("data.price");
            String Request_model=J2.get("data.model");
            
            
            
            // Step 2: Send the file content in a POST request
            Response response = given()
                    .header("Content-Type", "application/json")  // Set content type
                    .body(jsonPayload)  // Pass the file content as the request body
            .when()
                    .post("https://api.restful-api.dev/objects")  // Specify the endpoint
            .then()
                    .statusCode(200)  // Check for a successful response (status code 200)
                    .extract().response();

            // Step 3: Print the response
            System.out.println("Response Body: " + response.asString());
            
            
            JsonPath J1 = response.jsonPath();
            
            String id=J1.get("id");
            String name=J1.get("name");
            String createdAt= J1.get("createdAt");
            Integer year=J1.getInt("data.year");
            Float price=J1.getFloat("data.price");
           
            //String model=J1.get("data.model");
           //String Hard_disk_size=J1.get("data.Hard disk size");
           
           
           System.out.println("id : "+id);
           System.out.println("name :"+name);
           System.out.println("createdAt : "+createdAt);
           System.out.println("year : "+year);
           System.out.println("price : "+price);
           //System.out.println("CPU : "+CPU);
           //System.out.println("model : "+model);
           //System.out.println("Hard_disk_size : "+Hard_disk_size);
           

           //Assert.assertEquals(id, Request_id);
           Assert.assertEquals(name, Request_name);
           Assert.assertEquals(year, Request_year);
           Assert.assertEquals(price, Request_price);
           
           

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        
        
        
        
        
        
        
        
        
        
    }
}