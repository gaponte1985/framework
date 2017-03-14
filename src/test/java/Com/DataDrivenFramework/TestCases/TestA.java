package Com.DataDrivenFramework.TestCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Com.DataDrivenFramework.Utilites.Xls_Reader;

public class TestA {
	
	@Test(dataProvider="getData")
	public void testA(String runmode,String col1,String col2,String col3, String col4){
		
	}
	
	
	@DataProvider
	public Object[][] getData(){
		Xls_Reader xls = new Xls_Reader("/Users/aponte/Documents/workspace/TheJamStopDDF/Com.DataDrivenFramework/src/test/java/Data.xlsx");
		String sheetName="Data";
		String testCaseName="TestA";
		
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
			Object[][] data = new Object[rows][cols];
			int dataRow =0;

			for (int rNum=dataStartRowNum;rNum<dataStartRowNum+rows;rNum++){
				for(int cNum=0;cNum<cols;cNum++)
				{
					data[dataRow][cNum] = xls.getCellData(sheetName, cNum, rNum);					
			
				}
				dataRow++;
			}
			return data;
		
	}
}
