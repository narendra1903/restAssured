package ExcelUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test3 {

	public static void main(String[] args) {
		
		
		 Object [][] objArray = new Object[4][3];
		 
		 objArray[0][0]="100";
		 objArray[0][1]="Venkat";
		 objArray[0][2]="Kumar";
 
		 objArray[1][0]="200";
		 objArray[1][1]="Venkat1";
		 objArray[1][2]="Kumar1";
		 
		 objArray[2][0]="300";
		 objArray[2][1]="Venkat2";
		 objArray[2][2]="Kumar2";
		 
		 objArray[3][0]="400";
		 objArray[3][1]="Venkat3";
		 objArray[3][2]="Kumar3";
		 
	//	 System.out.println("Object Array :"+objArray[0][0]);
	//	 System.out.println("Object Array :"+objArray[0][1]);
		// System.out.println("Object Array :"+objArray[0][2]);
		 
		
	    Map<String, Map<String, String>> completeSheetData = new HashMap<String, Map<String, String>>();
	    
	    //{1={SNO=200, SNAME=Venkat1, SCITY=Kumar1}, 2={SNO=300, SNAME=Venkat2, SCITY=Kumar2}}

	     List<String> columnHeader = new ArrayList<String>();
	     columnHeader.add("SNO");
	     columnHeader.add("SNAME");
	     columnHeader.add("SCITY");
	     
	     //System.out.println("Column Header 0"+columnHeader.get(0));
	    // System.out.println("Column Header 1"+columnHeader.get(1));
	     //System.out.println("Column Header 2"+columnHeader.get(2));
	     
	    
	     
	    // columnHeader.get(0);
	     int rowCount=4;
	     int columnCount=3;
	     
	     for (int i = 1; i < rowCount; i++) {
	    	 
	     
	    	   Map<String, String> singleRowData = new HashMap<String, String>(); 
	     
			     for (int j = 0; j < columnCount; j++) {
			     { 
				     singleRowData.put(columnHeader.get(j), (String) objArray[i][j]);
				     completeSheetData.put(String.valueOf(i), singleRowData);
			     }
	     
	     }
	
	 
	     System.out.println("Excel Data for 1st row and column- AccountNo : "+completeSheetData.get("1").get("SNO"));
	     System.out.println("Excel Data for 1st row and column- AccountNo : "+completeSheetData.get("1").get("SNAME"));
	     System.out.println("Excel Data for 1st row and column- AccountNo : "+completeSheetData.get("1").get("SCITY"));
	    
	     
	     
	     //System.out.println("Excel Data for 2nd row and column- AccountNo : "+completeSheetData.get("2").get("SNO"));
	    // System.out.println("Excel Data for 3rd row and column- AccountNo : "+completeSheetData.get("3").get("SNO"));
	    System.out.println("excelData as Map: "+completeSheetData);
	    
	   // System.out.println("Excel Data for 1st row and column- AccountNo : "+completeSheetData.get("2").get("SNO"));
	   //System.out.println("Excel Data for 1st row and column- AccountNo : "+completeSheetData.get("2").get("SNAME"));
		//System.out.println("Excel Data for 1st row and column- AccountNo : "+completeSheetData.get("2").get("SCITY"));
		    
		  
	
	}

}
}