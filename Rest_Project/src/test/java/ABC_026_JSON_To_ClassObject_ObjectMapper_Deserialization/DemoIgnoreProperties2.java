package ABC_026_JSON_To_ClassObject_ObjectMapper_Deserialization;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DemoIgnoreProperties2 {

	@Test
	public void test1() throws JsonMappingException, JsonProcessingException
	{
        // Example JSON response
        String jsonResponse = "{\"firstname\": \"John\", \"age\": 30}";

        // Create an ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        // Convert JSON string to a Java object
        try {
        	
        
        	Employee myObject = objectMapper.readValue(jsonResponse, Employee.class);

            // Print the Java object
            System.out.println(myObject.getFirstname()); // Output: John
            System.out.println(myObject.getAge());  // Output: 30
            
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
