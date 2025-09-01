package ABC_050_SSL_Invalid_HostNames;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

	public class SSLConfigurationTest {

	    @Test
	    public void testSSLConfiguration() {
	        // Configure Rest Assured to use SSL
	        RestAssured.useRelaxedHTTPSValidation(); // Use relaxed HTTPS validation

	        // Optionally, you can configure more advanced SSL settings:
	        // RestAssured.config().sslConfig(SSLConfig.sslConfig().allowAllHostnames());

	        // Specify the base URL
	        String baseUrl = "https://api.example.com";

	        // Perform an HTTPS request
	        RequestSpecification request = RestAssured.given().baseUri(baseUrl);

	        // Example: send a GET request
	        request.get("/endpoint").then().statusCode(200);
	    }
	}