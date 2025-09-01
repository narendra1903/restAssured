package Day005_Multi_value_headers;

import org.testng.annotations.Test;

import com.google.common.io.CharStreams;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;


import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;


import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TC01_HeadersExample {
	
	@Test
    public void Test1() {
        // Send a GET request to an example endpoint
        Response response = RestAssured.get("https://jsonplaceholder.typicode.com/posts/1");

        // Get all headers from the response
        Headers headers = response.getHeaders();

        // Get values associated with the 'Content-Type' header
        List<String> contentTypeValues = headers.getValues("Content-Type");

        // Print all values associated with the 'Content-Type' header
        System.out.println("Content-Type Header Values:");
        for (String value : contentTypeValues) {
            System.out.println(value);
            System.out.println("___________");
        }
    }
}