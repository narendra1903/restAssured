package Day005_xml_Path;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class xmlPath2 {

    @Test
    public void testXmlPath() {
       
    RestAssured.baseURI = "http://example.com/api";
        
   	 RequestSpecification httpRequest = RestAssured.given();
   	// Response response = httpRequest.get("/lotto.json");

     String xml =httpRequest.post("/greetXML.xml?firstName=John&lastName=Doe").andReturn().asString();
 

     // or a bit more efficiently:
     XmlPath xmlPath = new XmlPath(xml).setRoot("greeting");
     String firstName = xmlPath.get("firstName");
     String lastName = xmlPath.get("lastName");
    }
}