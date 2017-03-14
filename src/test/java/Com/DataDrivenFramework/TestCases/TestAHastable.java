package Com.DataDrivenFramework.TestCases;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Com.DataDrivenFramework.Utilites.Xls_Reader;

public class TestAHastable {
	
	@Test(dataProvider="getData")
	public void testA(Hashtable<String,String>data){
		
		System.out.println(data.get("Runmode")+"-----"+data.get("Col1")+"-----"+data.get("Col2")+"-----"+data.get("Col3")+"-----"+data.get("Col4"));
		
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
			Object[][] data = new Object[rows][1];
			int dataRow =0;
			Hashtable<String,String> table;

			for (int rNum=dataStartRowNum;rNum<dataStartRowNum+rows;rNum++){
				table = new Hashtable<String,String>();
				for(int cNum=0;cNum<cols;cNum++)
				{
					String key = xls.getCellData(sheetName, cNum, colStartRowNum);
					String value = xls.getCellData(sheetName, cNum, rNum);
					table.put(key, value);
					//data[dataRow][cNum] = xls.getCellData(sheetName, cNum, rNum);					
			
				}
				data[dataRow][0]=table;
				dataRow++;
			}
			return data;
		
	}
}
