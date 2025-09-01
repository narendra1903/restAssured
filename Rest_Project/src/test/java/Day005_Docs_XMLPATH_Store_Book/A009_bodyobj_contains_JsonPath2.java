package Day005_Docs_XMLPATH_Store_Book;

import org.testng.annotations.Test;

import com.google.common.io.CharStreams;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.path.xml.element.Node;
import io.restassured.path.xml.element.NodeChildren;
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
import java.util.Map;

import org.testng.asserts.Assertion;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.testng.Assert; 

public class A009_bodyobj_contains_JsonPath2 
{
	
	//https://www.javadoc.io/doc/io.rest-assured/json-path/latest/io/restassured/path/json/JsonPath.html
	
	
	@Test
	public void WeatherMessageBody() throws IOException
	{
	 RestAssured.baseURI = "http://localhost:8080/shopping1.xml";
	 RequestSpecification https = RestAssured.given();
	// Response response = httpRequest.get("/2");
	 
	 Response response= https.request(Method.GET,"");

	// String JSON = response.getBody().asString();
	 
	// response.prettyPrint();
	
	ResponseBody body=response.body();
	String XML=body.asString();
	
	//System.out.println("XML Is :"+XML);
	
	//response.prettyPrint();
	
    String names = XmlPath.with(XML).get("shopping.category.item[0].name");
    int items = XmlPath.with(XML).get("shopping.category.item.size()");
    int items1 = XmlPath.with(XML).get("shopping.category.findAll { it.@type == 'groceries' }.size()");
	
    Node category = XmlPath.with(XML).get("shopping.category[0]");
   Map<String, String> Name= category.attributes();
   //System.out.println(Name); //{type=groceries}
   

   //Get all items with price greater than or equal to 10 and less than or equal to 20:

	   List<Node> itemsBetweenTenAndTwenty = XmlPath.with(XML).get("shopping.category.item.findAll { item -> def price = item.price.toFloat(); price >= 10 && price <= 20 }");
	   
	   for(Node N1:itemsBetweenTenAndTwenty)
	   {
		   System.out.println(N1.attributes());
		   System.out.println(N1.children());
	   }
    
	}
}
