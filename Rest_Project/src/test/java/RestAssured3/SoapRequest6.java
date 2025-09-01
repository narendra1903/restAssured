package RestAssured3;

import org.testng.annotations.Test;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.path.xml.XmlPath;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class SoapRequest6 
{
	
	
	//http://parabank.parasoft.com/parabank/services/bank/customers/12212/
	//https://www.ontestautomation.com/testing-rest-services-with-rest-assured/
	//http://learn-automation.com/configure-rest-assured-with-eclipse/
	
	//RequestSpecification request = RestAssured.given();
	// String firstName = request.get("/greetXML").xmlPath().getString("greeting.firstName"); 
	
	//  String name = with(XML).get("shopping.category.item[0].name");
	
	@Test
	public void listCountries()
	{
		RestAssured.baseURI = "http://parabank.parasoft.com";
		Response response = null;
		RequestSpecification request = RestAssured.given();
		request.contentType(ContentType.XML);
		
		response=request.get("/parabank/services/bank/customers/12212/"); 
		
		int statusCode = response.getStatusCode();
		System.out.println("The status code recieved: " + statusCode);
		System.out.println("Response body: " + response.body().asString());
		
		String str   =response.body().asString();
		XmlPath xmlpath = new XmlPath(str);
		
		String customerid = xmlpath.getString("customer.id");	
		System.out.println("customer id: " + customerid);
		System.out.println("customer id: " + xmlpath.getString("customer.firstName"));
		System.out.println("customer id: " + xmlpath.getString("customer.lastName"));
		
		System.out.println("customer address: " + xmlpath.getString("customer.address.street"));
		System.out.println("customer Phone#: " + xmlpath.getString("customer.phoneNumber"));
		System.out.println("customer ssn#: " + xmlpath.getString("customer.ssn"));
     }
	 
	 
	 
}
