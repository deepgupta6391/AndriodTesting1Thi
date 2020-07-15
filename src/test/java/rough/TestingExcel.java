package rough;

import java.util.Hashtable;

public class TestingExcel {
	

	public static void main(String[] args) {
		ExcelReadingMine excel=new ExcelReadingMine("F:\\Appium Series\\PageObjectModelWithPageFactories\\src\\test\\resources\\testdata\\FlipBoardSuite.xlsx");
		
		int rows=excel.getRowCount("TestData");
		System.out.println("Total number of rows are "+rows);
		
		String testName="searchItemTest";
		
		//Find the testcase row number
		int testCaseRowNum=1;
		
		for(testCaseRowNum=1;testCaseRowNum<=rows;testCaseRowNum++)
		{
			String testCaseName=excel.getCellData("TestData",0, testCaseRowNum);
			if(testCaseName.equalsIgnoreCase(testName))
				break;				
		}
		
		System.out.println("Test case starts from row num "+testCaseRowNum);
		
		//checking total rows in test case
		
		int testDataStartRowNum=testCaseRowNum+2;
		
		int testRows=0;
		while(!excel.getCellData("TestData", 0, testDataStartRowNum+testRows).equals(""))
		{
			testRows++;
		}
		
		System.out.println("Total number of test rows are "+testRows);
		
		//Checking total Cols in test case
		
		int colStartRowNum=testCaseRowNum+1;
		
		int testCols=0;
		while(!excel.getCellData("TestData", testCols, colStartRowNum).equals("")) {
			testCols++;
		}
		
		System.out.println("Total number if test cols are "+testCols);
	
	
		//Printing data
		
		Object[][] data=new Object[testRows][1];
		
		int i=0;
		for(int rNum=testDataStartRowNum;rNum<(testDataStartRowNum+testRows);rNum++) {
			
			Hashtable<String,String> table=new Hashtable<String, String>();
			
			for(int cNum=0;cNum<testCols;cNum++) {
				
				//data[rNum-testDataStartRowNum]=excel.getCellData("TestData", cNum, rNum);
				String testData=excel.getCellData("TestData", cNum, rNum);
				String colName=excel.getCellData("TestData", cNum, colStartRowNum);
				
				table.put(colName,testData);
				System.out.println(colName+" value is "+testData);
			}
			
			data[i][0]=table;
			i++;

		}
		
		
		
	}

}
