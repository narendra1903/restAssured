package ExcelUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test2 {

	public static void main(String[] args) {
		
		
		 Object [][] objArray = new Object[2][3];
		 
		 objArray[0][0]="200";
		 objArray[0][1]="Venkat";
		 objArray[0][2]="Kumar";
		 
		 
		 objArray[1][0]="300";
		 objArray[1][1]="Venkat1";
		 objArray[1][2]="Kumar1";
		 
		 System.out.println("Object Array :"+objArray[0][0]);
		 System.out.println("Object Array :"+objArray[0][1]);
		 System.out.println("Object Array :"+objArray[0][2]);
		 
		
	    Map<String, Map<String, String>> completeSheetData = new HashMap<String, Map<String, String>>();

	     List<String> columnHeader = new ArrayList<String>();
	     columnHeader.add("SNO");
	     columnHeader.add("SNAME");
	     columnHeader.add("SCITY");
	     
	     System.out.println("Column Header 0"+columnHeader.get(0));
	     System.out.println("Column Header 1"+columnHeader.get(1));
	     System.out.println("Column Header 2"+columnHeader.get(2));
	     
	    
	     
	    // columnHeader.get(0);
	     
	     Map<String, String> singleRowData = new HashMap<String, String>();    
	     singleRowData.put("SNO", "101");
	     singleRowData.put("SNAME", "Sudhakar");
	     singleRowData.put("SCITY", "Hyderabad");
	     completeSheetData.put(String.valueOf(1), singleRowData);
	     
	     Map<String, String> singleRowData1 = new HashMap<String, String>();
	     singleRowData1.put("SNO", "201");
	     singleRowData1.put("SNAME", "Ravi");
	     singleRowData1.put("SCITY", "Guntur");
	     completeSheetData.put(String.valueOf(2), singleRowData1);
	     
	     Map<String, String> singleRowData2 = new HashMap<String, String>();
	     singleRowData2.put("SNO", "301");
	     singleRowData2.put("SNAME", "Kiran");
	     singleRowData2.put("SCITY", "Vizag");
	     completeSheetData.put(String.valueOf(3), singleRowData2);
	     
	
	     System.out.println("Excel Data for 1st row and column- AccountNo : "+completeSheetData.get("1").get("SNO"));
	     System.out.println("Excel Data for 2nd row and column- AccountNo : "+completeSheetData.get("2").get("SNO"));
	     System.out.println("Excel Data for 3rd row and column- AccountNo : "+completeSheetData.get("3").get("SNO"));
	     System.out.println("excelData as Map: "+completeSheetData);
	
	}

}
