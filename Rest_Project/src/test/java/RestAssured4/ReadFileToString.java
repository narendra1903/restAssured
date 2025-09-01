package RestAssured4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
 
public class ReadFileToString 
{
    public static void main(String[] args) throws IOException 
    {
        String filePath = "D:\\Selenium _backup\\OrangeHRM12\\src\\test\\java\\RestAssured4\\shopping3.xml";
        String out = String.join("\n", Files.readAllLines(Paths.get(filePath)));
        System.out.println(out);
    }
    
   
 
   
}
