package ExcelUtil;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class ExcelReader3 {
	

    
    public static void main(String[] args) throws IOException {
    	ExcelApiTest4 ex = new ExcelApiTest4();
        Map<String, Map<String, String>> excelData =ex.getExcelAsMap("C://HTML Report//OrangeHRM6//TC01_Nationality1.xlsx","Sheet1",0);
        System.out.println("Excel Data for 2nd row and column- AccountNo : "+excelData.get("2").get("Nationality"));
        System.out.println("excelData as Map: "+excelData);
    }

}
