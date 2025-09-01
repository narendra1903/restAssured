package POJO_001_SimpleJson;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

public class CreateUserTest {

    public static void main(String[] args) {
        // Set base URI
        RestAssured.baseURI = "https://your-api-url.com/api";

        // Create user object
        User user = new User("John Doe", "john@example.com", 30);

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
