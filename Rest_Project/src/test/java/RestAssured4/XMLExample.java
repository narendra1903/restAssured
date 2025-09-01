package RestAssured4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class XMLExample {
	

	public static String Return_File_Content(String FilePath) throws IOException 
	{
	 
	    String out = String.join("\n", Files.readAllLines(Paths.get(FilePath)));
	    //System.out.println(out);
	    return out;
	}
	
	@Test
	public void Test2() throws Exception
	{

		String filePath = "D:\\Selenium _backup\\OrangeHRM12\\src\\test\\java\\RestAssured4\\shopping3.xml";
		String json =Return_File_Content(filePath);
		JsonPath jsonPath = new JsonPath(json);
		
	}
	

}




