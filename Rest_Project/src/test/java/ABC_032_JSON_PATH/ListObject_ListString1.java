package ABC_032_JSON_PATH;

import static org.hamcrest.Matchers.hasItems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;

import org.hamcrest.Matchers;
import org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import io.restassured.path.json.JsonPath;

public class ListObject_ListString1 
{
	
	
	
	@Test
	public void WeatherMessageBody()
	{
		
	//https://www.javadoc.io/doc/io.rest-assured/json-path/latest/io/restassured/path/json/JsonPath.html
		
	 RestAssured.baseURI = "http://localhost:8080";
	 RequestSpecification httpRequest = RestAssured.given()
			 .contentType(ContentType.JSON);

	 Response response = httpRequest.get("/store.json");

	 String JSON = response.getBody().asString();
	 //System.out.println("Response Body1 is =>  " + response.asString());
	 	 
	
	 
	 JsonPath j1 = response.jsonPath();
	
	 int statusCode = response.getStatusCode();
	 System.out.println("statusCode is :"+statusCode);
	 
	// To get a list of all book categories:
	List<String> categories =j1.get("store.book.category");
	 System.out.println("store.book.category are :"+statusCode);	
	
		 
	//Get the first book category:
	String Firstbookcategory = j1.get("store.book[0].category");	
	 System.out.println("store.book[0].category :"+Firstbookcategory);
		 
	//Get the last book category:
	String lastbookcategory = j1.get("store.book[-1].category");
	System.out.println("store.book[-1].category :"+lastbookcategory);
		 
	//Get all books with price between 5 and 15:	 
	 List<Map> books = j1.
	get("store.book.findAll { book -> book.price >= 5 && book.price <= 15 }");	 
	System.out.println("Books range between 5 and 15 :"+books)	; 
	 
	 
	 //String name = System.console().readLine();
	 String name="Evelyn Waugh";
	 List<Map> books1 =j1.
			 get("store.book.findAll { book -> book.author == '" + name + "' }");
	System.out.println("Finding Book author is Evelyn Waugh :"+books1)	; 
		 
	
	JsonPath jsonPath = new JsonPath(JSON).setRoot("store.book");
	System.out.println(jsonPath.getInt("size()"));
	System.out.println(jsonPath.getList("author", String.class));
	//assertThat(jsonPath.getInt("size()"), equalTo(4));
	 assertThat(jsonPath.getInt("size()"), is(4));
	 assertThat(jsonPath.getList("author", String.class), Matchers.hasItem("J. R. R. Tolkien"));
	 assertThat(jsonPath.getList("author", String.class), Matchers.hasItems("J. R. R. Tolkien","Nigel Rees"));
	 //Matchers.
	 
	 //Matchers.hasItem("Sss/12345637/58")
	 /*List<Object> l1=new ArrayList<Object>();
	 l1=j1.getList("store.book.category");
	 System.out.println(l1);
	 
	 List<String> l2=new ArrayList<String>();
	 l2=j1.getList("store.book.category");
	 System.out.println(l2);
	 
	 List<Object> l3=new ArrayList<Object>();
	 l3.add("Hai");
	 l3.add(1);
	 System.out.println(l3);*/
	 
	 System.out.println("1._________________________________");
	 
	 final Map<String, Object> store = JsonPath.from(JSON).get("store.book[0]");
     
     for (Map.Entry<String, Object> stringObjectEntry : store.entrySet()) {
         System.out.println(stringObjectEntry.getKey() + " = " + stringObjectEntry.getValue());
     }
	 
	 
	 
	 
	}
}
