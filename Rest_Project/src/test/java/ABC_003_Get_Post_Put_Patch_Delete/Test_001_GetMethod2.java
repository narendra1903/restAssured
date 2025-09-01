package ABC_003_Get_Post_Put_Patch_Delete;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.io.CharStreams;

import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Map;
import java.util.Map.Entry;

import io.restassured.RestAssured;
import io.restassured.http.Cookie;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.path.xml.XmlPath.CompatibilityMode;
import io.restassured.response.Response;
//import junit.framework.Assert;

public class Test_001_GetMethod2 {

	
	@Test
	public void test02() throws IOException
	{
		//given , when, then
		RestAssured.baseURI="https://reqres.in/api/users";
		
		Response response=
				
		RestAssured.given()
		.queryParam("page", "2")
		.when()
		.get()
		.then()
		.statusCode(200)
		.and().extract().response();
		
		
		response.prettyPrint();
		
		System.out.println("Response code:" + response.getStatusCode());
		System.out.println("Response getStatusLine:" + response.getStatusLine());
		System.out.println("Response body:" + response.getBody().asString());
		System.out.println("Response Time:" + response.getTime());
		System.out.println("Response Header:" + response.getHeader("Content-Type"));
		System.out.println("Response Session id:" + response.getSessionId());

		
		
		//Print Cookies Information
		Map<String,String> cookies=response.getCookies();
		for (Map.Entry<String,String> cookie : cookies.entrySet())
		{
            System.out.println("Key = " + cookie.getKey() + 
                             ", Value = " + cookie.getValue()); 
            System.out.println("_______________________________");
		}
		// Get a single cookie value:
		//String cookieValue = response.getCookie("cookieName");
		
		
		
		//Print Headers Information
		Headers allHeaders = response.getHeaders();
		for(Header header : allHeaders)
		{
			System.out.print(header.getName() +" : ");
			System.out.println(header.getValue());
			System.out.println("_____________________");
		}
		// Get a single header value:
		//String headerName = response.getHeader("headerName");
		
		
		 //1.Print response.asString(); 
		 String json = response.asString();
		 System.out.println(json);
		 
		
		 //2.Print response.asByteArray(); 
		 byte[] byteArray =response.asByteArray();
		 System.out.println("________________________________________________");
		 System.out.println(new String(byteArray, 0));
		
		 
		 //3.Print response.asInputStream(); 
		InputStream stream=response.asInputStream();
		String text = null;
		    try (Reader reader = new InputStreamReader(stream)) {
		        text = CharStreams.toString(reader);
		    }
		    System.out.println(text);
		System.out.println("________________________________________________");
		
		
		
		 // Validate Response JSON inner details information
		 JsonPath j1 = response.jsonPath();
		
		  
		 // Validate Response XML inner details information
		 XmlPath x1 = response.xmlPath();
		 
		 
		// String html1 = response.asString();
		 String html = "<html><body><h1>Hello, World!</h1></body></html>";
	     XmlPath HtmlPath = new XmlPath(CompatibilityMode.HTML, html);
	     HtmlPath.getString("html.body.h1");
	
		
	}
	
}
