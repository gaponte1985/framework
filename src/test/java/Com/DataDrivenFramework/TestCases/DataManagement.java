package Com.DataDrivenFramework.TestCases;

import Com.DataDrivenFramework.Utilites.Xls_Reader;

public class DataManagement {

	public static void main (String[] args){
    Xls_Reader xls = new Xls_Reader("/Users/aponte/Documents/workspace/TheJamStopDDF/Com.DataDrivenFramework/src/test/java/Data.xlsx");
	String sheetName="Data";
	String testCaseName="TestC";
	
	int testStartRowNum =1;
	while(!xls.getCellData(sheetName,0,testStartRowNum).equals(testCaseName)){
		testStartRowNum++;
	}
	System.out.println("TestRowNum: "+testStartRowNum);
	int colStartRowNum=testStartRowNum+1;
	int dataStartRowNum=testStartRowNum+2;
//calculate row of data
	
	int rows =0;
	while(!xls.getCellData(sheetName,0,dataStartRowNum+rows).equals("")){
	
	rows++;
	}
	System.out.println("rows: "+rows);

	int cols =0;
	while(!xls.getCellData(sheetName,cols,colStartRowNum).equals("")){
		
		cols++;
		}
		System.out.println("cols: "+cols);

		for (int rNum=dataStartRowNum;rNum<dataStartRowNum+rows;rNum++){
			for(int cNum=0;cNum<cols;cNum++)
			{
				System.out.println(xls.getCellData(sheetName, cNum, rNum));
				
			}
		}
	}
	
	
	
}
