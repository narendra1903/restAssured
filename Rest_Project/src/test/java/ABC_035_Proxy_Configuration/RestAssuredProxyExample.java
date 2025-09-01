package ABC_035_Proxy_Configuration;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RestAssuredProxyExample {

    public static void main(String[] args) {
        // Set proxy host and port
        String proxyHost = "your.proxy.host";
        int proxyPort = 8080;

        // Set proxy username and password if authentication is required
        String proxyUsername = "your_username";
        String proxyPassword = "your_password";

        // Build proxy specification
        RequestSpecification requestSpec = new RequestSpecBuilder()
                .setProxy(proxyHost, proxyPort)
                .build();

        // If proxy authentication is required
        if (proxyUsername != null && proxyPassword != null) {
            requestSpec.auth().preemptive().basic(proxyUsername, proxyPassword);
        }

        // Set the base URI for your API endpoint
        RestAssured.baseURI = "https://api.example.com";

        // Use the proxy configuration for all requests
        RestAssured.requestSpecification = requestSpec;

        // Now you can make requests using Rest Assured
        // For example:
        RestAssured.given()
                .when()
                .get("/endpoint")
                .then()
                .statusCode(200);
    }
}