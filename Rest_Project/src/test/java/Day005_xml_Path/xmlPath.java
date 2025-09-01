package Day005_xml_Path;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class xmlPath {

    @Test
    public void testXmlPath() {
        RestAssured.baseURI = "http://example.com/api";

        given().
            when().
                get("/books").
            then().
                assertThat().
                body("bookstore.book[0].title", equalTo("Everyday Italian"));
    }
}