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

public class ExcelReader2 {
	
	FileInputStream fis;
	HSSFWorkbook workbook;
	HSSFSheet sheet ;
	HSSFRow row;
	HSSFCell cell ;
	
	private String filePath;
    private int sheetIndex;
    ExcelReader2(String filePath, int sheetIndex) {
        this.filePath = filePath;
        this.sheetIndex = sheetIndex;
    }
    private HSSFSheet getSheet() throws IOException {
        fis = new FileInputStream(filePath);
        workbook = new HSSFWorkbook(fis);
        sheet = workbook.getSheetAt(sheetIndex);
        return sheet;
    }
    public Map<String, Map<String, String>> getExcelAsMap() throws IOException {
       sheet = getSheet();
        Map<String, Map<String, String>> completeSheetData = new HashMap<String, Map<String, String>>();
        List<String> columnHeader = new ArrayList<String>();
        //Row row = sheet.getRow(0);
        row = sheet.getRow(0);
        Iterator<Cell> cellIterator = row.cellIterator();
        while (cellIterator.hasNext()) {
            columnHeader.add(cellIterator.next().getStringCellValue());
        }
        int rowCount = row.getLastCellNum();
        int columnCount = row.getLastCellNum();
        for (int i = 1; i <= rowCount; i++) {
            Map<String, String> singleRowData = new HashMap<String, String>();
             row = sheet.getRow(i);
            for (int j = 0; j < columnCount; j++) {
            	 cell = row.getCell(j);
            	 //cell = row.getCell(column);
                singleRowData.put(columnHeader.get(j), getCellValueAsString(cell));
            }
            completeSheetData.put(String.valueOf(i), singleRowData);
        }
        return completeSheetData;
    }
    /*
    public String getCellValueAsString(Cell cell) {
        String cellValue = null;
        switch (cell.getCellType()) {
            case NUMERIC:
                cellValue = String.valueOf(cell.getNumericCellValue());
                break;
            case STRING:
                cellValue = cell.getStringCellValue();
                break;
            case BOOLEAN:
                cellValue = String.valueOf(cell.getBooleanCellValue());
                break;
            case FORMULA:
                cellValue= cell.getCellFormula();
            case BLANK:
                cellValue="BLANK";
            default:
                cellValue ="DEFAULT";
        }
        return cellValue;
    }*/

    private String getCellValueAsString(Cell cell) {
		// TODO Auto-generated method stub
    	String cellValue = null;
    	
    	
            //  cellValue = cell.getStringCellValue();
              if(cell.getCellTypeEnum() == CellType.STRING)
              {	
              	 cellValue=cell.getStringCellValue();
        
                  return cellValue;
              }
              else if(cell.getCellTypeEnum() == CellType.NUMERIC)
              {	
              	//int str6=cell.getStringCellValue();
              	int i = (int)cell.getNumericCellValue(); 
              	cellValue = String.valueOf(i); 
           
                  return cellValue;
              }
              
              
              
              
              else 
              {
            	  cellValue=cell.getStringCellValue();
            
                  return cellValue;
              }
    	 
    	 	
	}
    
    
    
	public String getSheetName(int index) throws IOException {
        FileInputStream file = new FileInputStream(filePath);
         workbook = new HSSFWorkbook(file);
        String sheet = workbook.getSheetName(index);
        return sheet;
    }
    public int getSheetCount() throws IOException {
        FileInputStream file = new FileInputStream(filePath);
         workbook = new HSSFWorkbook(file);
        int sheetCount = workbook.getNumberOfSheets();
        return sheetCount;
    }
    public int totolColumnCount() throws IOException {
        sheet = getSheet();
        row = sheet.getRow(0);
        int lastColumnNum = row.getLastCellNum();
        return lastColumnNum;
    }
    
    
    /*  public String getCellValueAsString(Cell cell) {
        String cellValue = null;
        switch (cell.getCellType()) {
            case NUMERIC:
                cellValue = String.valueOf(cell.getNumericCellValue());
                break;
            case STRING:
                cellValue = cell.getStringCellValue();
                break;
            case BOOLEAN:
                cellValue = String.valueOf(cell.getBooleanCellValue());
                break;
            case FORMULA:
               cellValue= cell.getCellFormula();
            case BLANK:
                cellValue="BLANK";
            default:
                cellValue ="DEFAULT";
        }
        return cellValue;
    } */
    
    public static void main(String[] args) throws IOException {
        ExcelReader2 ex = new ExcelReader2("C:\\HTML Report\\OrangeHRM6\\TC01_Nationality191.xls", 1);
        Map<String, Map<String, String>> excelData =ex.getExcelAsMap();
        System.out.println("Excel Data for 2nd row and column- AccountNo : "+excelData.get("2").get("Nationality"));
        System.out.println("excelData as Map: "+excelData);
    }

}
