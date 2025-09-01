package POJO_003_nessted_json_multiple_addresses;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

import java.util.Arrays; 
import java.util.List; 
 
public class CreateUserTest { 
    public static void main(String[] args) { 
        RestAssured.baseURI = "https://your-api-url.com/api"; 
 
        // Create multiple addresses 
        Address address1 = new Address("123 Main St", "New York", "10001"); 
        Address address2 = new Address("456 Side St", "Boston", "02118"); 
        List<Address> addressList = Arrays.asList(address1, address2); 
 
        // Create user with multiple addresses 
        User user = new User("Alice", "alice@example.com", 25, addressList); 
 
        // Send POST request 
        given() 
            .contentType(ContentType.JSON) 
            .body(user) 
        .when() 
            .post("/users") 
        .then() 
            .statusCode(201) 
            .log().body(); 
    } 
}