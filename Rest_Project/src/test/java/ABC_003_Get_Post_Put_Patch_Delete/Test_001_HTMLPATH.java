package ABC_003_Get_Post_Put_Patch_Delete;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.io.CharStreams;

import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Map;
import java.util.Map.Entry;

import io.restassured.RestAssured;
import io.restassured.http.Cookie;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.path.xml.XmlPath.CompatibilityMode;
import io.restassured.response.Response;
//import junit.framework.Assert;

public class Test_001_HTMLPATH {

	
	@Test
	public void test02() throws IOException
	{
		
		 
		// String html1 = response.asString();
		 String html = "<html><body><h1>Hello, Sudhakar!</h1></body></html>";
	     XmlPath HtmlPath = new XmlPath(CompatibilityMode.HTML, html);
	     String str=HtmlPath.getString("html.body.h1");
	
		System.out.println(str);
	}
	
}
