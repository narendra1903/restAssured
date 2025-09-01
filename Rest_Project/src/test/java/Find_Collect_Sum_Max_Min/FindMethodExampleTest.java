package Find_Collect_Sum_Max_Min;
import io.restassured.RestAssured;
import io.restassured.response.Response;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;




public class FindMethodExampleTest {

    @Test
    public void testFindMethod() {
        // Set base URI
        RestAssured.baseURI = "https://api.example.com";

        // Send a GET request to retrieve an XML response
        Response response = get("/example"); // Replace "/example" with your actual endpoint

        // Use the find() method with XPath to locate specific elements in the XML response
   // String value = response.xmlPath().
   // get("elementName.subElement.find { it.@attributeName == 'attributeValue' }.text()");

    String value1 = response.jsonPath().
    	    get("elementName.subElement.find { it.@attributeName == 'attributeValue' }.text()");

    
    
        // Perform assertions or further processing
        System.out.println("Value found: " + value1);

        // Example assertion
      //Assert.assertThat(value, equalTo("expectedValue"));
       
       Assert.assertEquals(value1, "expectedValue");
    }
}