package Day005_Multi_value_Cookies;

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
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TC01_CookiesExample {
	
	@Test
    public void Test1() {
		 Response response = RestAssured.get("https://www.stackoverflow.com");

	        // Get all cookies from the response
	        Cookies cookies = response.getDetailedCookies();

	        // Get values associated with the 'cookie1' cookie
	        List<String> cookie1Values = cookies.getValues("prov");

	        // Print all values associated with the 'cookie1' cookie
	        System.out.println("Values associated with 'prov':");
	        
	        for (String value : cookie1Values) {
	            System.out.println(value);
	        }
    }
}