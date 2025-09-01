package CommonUtil;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestData {
	
	   public FileInputStream fis = null;
	    public XSSFWorkbook workbook = null;
	    public XSSFSheet sheet = null;
	    public XSSFRow row = null;
	    public XSSFCell cell = null;
	    public FileOutputStream fout=null;
	
	
	public Map<String, String>  getData(){
		
	
			
			Map<String, String> testdata = new LinkedHashMap<>();
			
			
			
			try
			{
				String FilePath="OR.xlsx";
				
			      fis = new FileInputStream(FilePath);
			      workbook = new XSSFWorkbook(fis);
			      sheet = workbook.getSheet("Sheet1");
			      Iterator<Row> rowIterator = sheet.iterator();
			      
			
			      
			      while(rowIterator.hasNext())
			      {
			          Row row=rowIterator.next();
				      Iterator<Cell> cellIterator=row.cellIterator();
				      while(cellIterator.hasNext())
				      {
				    	  Cell cell=cellIterator.next();
				    	  cell.setCellType(CellType.STRING);
				    	  //testdata.put(cell.getRichStringCellValue(), cellIterator.next().getStringCellValue());
				    	  
				    	 // RichTextString str1=cell.getRichStringCellValue();
				    	  testdata.put(cell.getStringCellValue(), cellIterator.next().getStringCellValue());
				    	  
				      }
			      }
			      
				fis.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return testdata;
			
	}
}
