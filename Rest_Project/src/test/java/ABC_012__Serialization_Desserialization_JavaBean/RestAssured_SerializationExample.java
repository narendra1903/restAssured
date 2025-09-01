package ABC_012__Serialization_Desserialization_JavaBean;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class RestAssured_SerializationExample {

	@Test
    public void Test1() {
        // Base URI of the API endpoint
        RestAssured.baseURI = "https://dummy.restapiexample.com";

        // Create a User object
        User user = new User();
        user.setName("Kiran");
        user.setSalary("35000");
        user.setAge("35");
 

        // Send the User object as JSON in the request body
        RestAssured.given()
                .contentType(ContentType.JSON) // Specify content type as JSON
                .body(user) // Serialize the User object
                .when()
                .post("/api/v1/create") // HTTP POST request to /users endpoint
                .then()
                .statusCode(200).log().all(); // Assert response status code
    }
}