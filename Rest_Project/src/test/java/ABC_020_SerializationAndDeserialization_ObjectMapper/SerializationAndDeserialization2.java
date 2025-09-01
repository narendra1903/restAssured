package ABC_020_SerializationAndDeserialization_ObjectMapper;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class SerializationAndDeserialization2 {

	
	@Test
	public void CreateJSONObjectFromEmployeeClassObject() throws JsonProcessingException
	{
		
		//Created a pojo class for Employee Object with setter & getter methods
		Employee2 emp1 = new Employee2();
		emp1.setFirstname("Suresh");
		emp1.setLastname("Mehra");
		emp1.setGender("Male");
		emp1.setAge(35);
		emp1.setSalary(10000.00);
		
		Employee2 emp2 = new Employee2();
		emp2.setFirstname("Sureshss");
		emp2.setLastname("Mehrass");
		emp2.setGender("Male");
		emp2.setAge(45);
		emp2.setSalary(20000.00);
		
		
		List<Employee2> l1=new ArrayList<Employee2>();
		l1.add(emp1);
		l1.add(emp2);
		
		//convert employee class object to json payload as string
		ObjectMapper objMapper = new ObjectMapper();
		String employeeJSON = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(l1);
		System.out.println(employeeJSON);
		
		//create Request Specification 
	//	RequestSpecification reqSpec = RestAssured.given();
		
	//	reqSpec.baseUri("http://httpbin.org/post");
		//reqSpec.contentType(ContentType.JSON);
		//reqSpec.body(employeeJSON);
		
		//perform post request
		//Response response = reqSpec.post();
		
		//response.prettyPrint();
		
		//validate status code
		//Assert.assertEquals(response.statusCode(), 200,"Check for status code");
		
		
		
		
		
	}
}
