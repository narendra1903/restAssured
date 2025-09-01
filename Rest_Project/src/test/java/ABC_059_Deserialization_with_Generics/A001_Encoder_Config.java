package ABC_059_Deserialization_with_Generics;

import java.util.List;
import java.util.Map;

import org.apache.http.client.config.RequestConfig;

import org.testng.annotations.Test;
import org.json.simple.JSONObject;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;

public class A001_Encoder_Config {
	

	public void test1()
	{
	
		 RestAssured.baseURI = "http://localhost:8080";
		 RequestSpecification httpRequest = RestAssured.given();
		 Response response = httpRequest.get("/products.json");
		 //ResponseBody body = response.getBody();
		
		/* List<Map<String, Object>> products =
				 httpRequest.get("/products.json").
				 as(new TypeRef<List<Map<String, Object>>>() {});*/
		 
		 List<Map<String, Object>> products = response.
				 as(new TypeRef<List<Map<String, Object>>>() {});

		assertThat(products, hasSize(2));
		assertThat(products.get(0).get("id"), equalTo(2));
		assertThat(products.get(0).get("name"), equalTo("An ice sculpture"));
		assertThat(products.get(0).get("price"), equalTo(12.5));
		assertThat(products.get(1).get("id"), equalTo(3));
		assertThat(products.get(1).get("name"), equalTo("A blue mouse"));
		assertThat(products.get(1).get("price"), equalTo(25.5));

 
     
   
	
	}
	
	
	
	
	
  
}
