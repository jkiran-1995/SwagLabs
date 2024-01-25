package com.HybridAutomation.testCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.HybridAutomation.PageObjects.LoginPage;

public class TC_LoginDDT_002 extends BaseClass{
	
	@Test(dataProvider="CredentailsSupplier")
	public void loginDDT(String user, String Pwd) {
		driver.get(BaseURL);
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(user);
		lp.setPassword(Pwd);
		lp.ClickSubmit();
	}
	@DataProvider(name="CredentailsSupplier")
public Object[][] dataSupplier() throws IOException {
		
		File file = new File(System.getProperty("user.dir")+"/src/test/java/com/HybridAutomation/testData/TestData.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet Sheet = wb.getSheet("Sheet1");
		int rowCount = Sheet.getLastRowNum();
		int colCount = Sheet.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[rowCount][colCount];
		
		for(int r =0;r<rowCount;r++) {
			
			XSSFRow row = Sheet.getRow(r+1);
			for(int c =0;c<colCount;c++) {
				XSSFCell cell = row.getCell(c);
				
				CellType cellType = cell.getCellType();
				
				switch(cellType) {
				case STRING:
					data[r][c] = cell.getStringCellValue();
					break;
				case NUMERIC:
					data[r][c] = Integer.toString((int)cell.getNumericCellValue());
					break;
				case BOOLEAN:
					data[r][c] = cell.getBooleanCellValue();
					break;
				}
			}
		}
		return data;
	}


}
