package ABC_051_URL_Encoding;
import io.restassured.RestAssured;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.testng.annotations.Test;

public class URLEncodingTest {

    @Test
    public void testURLEncoding() {
        // Base URL of the API endpoint
        String baseUrl = "https://api.example.com";

        // Example parameter value to be encoded
        String parameterValue = "hello world"; 
        // Example parameter value with spaces

        // Encode the parameter value
        String encodedValue =
        		URLEncoder.encode(parameterValue);

        // Construct the full URL with encoded parameter
        String fullUrl = baseUrl + "/endpoint?param=" + encodedValue;

        // Perform the request with Rest Assured
        RestAssured.given()
                .when()
                .get(fullUrl)
                .then()
                .statusCode(200);
    }
}