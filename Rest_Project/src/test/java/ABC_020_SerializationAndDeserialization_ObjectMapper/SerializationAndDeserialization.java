package ABC_020_SerializationAndDeserialization_ObjectMapper;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class SerializationAndDeserialization {

	
	@Test
	public void CreateJSONObjectFromEmployeeClassObject() throws JsonProcessingException
	{
		
// first - We have to create a pojo class for java Object 
		//with setter & getter methods
		Employee emp1 = new Employee();
		emp1.setFirstName("Suresh");
		emp1.setLastname("Mehra");
		emp1.setGender("Male");
		emp1.setAge(35);
		emp1.setSalary(10000.00);
		
 //Second - we have to convert the java class object to json payload 
		//using ackson.databind.ObjectMapper
		//as
		ObjectMapper objMapper = new ObjectMapper();
		
		String employeeJSON = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp1);
		
		System.out.println(employeeJSON);
		
//in Step3 - We have to create Request Specification details  
//to process employeeJSON string object along with body
		
		RequestSpecification reqSpec = RestAssured.given();
		
		reqSpec.baseUri("http://httpbin.org/post");
		reqSpec.contentType(ContentType.JSON);
		reqSpec.body(employeeJSON);
		
// In Step 4 We will perform API post request method and we can get the response
		Response response = reqSpec.post();
		
		response.prettyPrint();
		
		//validate status code
		Assert.assertEquals(response.statusCode(), 200,"Check for status code");
		
		
	
		

		
		//converting JSON file to java Class object is known as deserialization
		
		// first - We have to create a pojo class for java class Object 
		//with setter & getter methods
		
		// we can do deserialization by using jackson.databind.ObjectMapper class)
		
		//We have to create object for ObjectMapper class as
		//	ObjectMapper objMapper = new ObjectMapper();
		Employee emp2 = objMapper.readValue(employeeJSON, Employee.class);
		
		System.out.println("-----------Print after JSON Object to Class Object------------");
		System.out.println("FirstName:"+ emp2.getFirstName());
		System.out.println("LastName:"+ emp2.getLastname());
		System.out.println("Gender:"+ emp2.getGender());
		System.out.println("Age:"+ emp2.getAge());
		System.out.println("Salary:"+ emp2.getSalary());
		
		
	}
}
