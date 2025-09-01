package Day005_xml_Path;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class xmlPath3 {

    @Test
    public void testXmlPath() {
       
 

    String xml = "<greeting><firstName>John</firstName><lastName>Doe</lastName></greeting>";

    // Convert the XML response string to an XmlPath object
    XmlPath xmlPath = new XmlPath(xml);

    
    String firstName = xmlPath.get("greeting.firstName");
    String lastName = xmlPath.get("greeting.lastName");

    System.out.println("First Name: " + firstName);
    
    System.out.println("last Name : " + lastName);
    
    }
}