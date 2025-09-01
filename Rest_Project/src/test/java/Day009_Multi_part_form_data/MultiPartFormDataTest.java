package Day009_Multi_part_form_data;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.io.File;

public class MultiPartFormDataTest {

    @Test
    public void sendMultiPartFormData() {
        File file = new File("path/to/your/file.txt");

        RestAssured.baseURI="";
        
        RestAssured.given()
                .multiPart("textFile", file) // Specify the file parameter name and the file
                .multiPart("param1", "value1") // Specify additional form fields if needed
                .multiPart("param2", "value2")
                .contentType("multipart/form-data") // Set content type
                .when()
                .post("your/api/endpoint") // Specify your API endpoint
                .then()
                .statusCode(200) // Assert the expected status code
                .contentType(ContentType.JSON); // Assert the expected content type
    }
}