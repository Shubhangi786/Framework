package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class DataProviderForTests {

	    public static Object[][] readEmailAddresses(String fileName) {
	    	String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\dataproviders\\" + fileName + ".xlsx";
	    	FileInputStream fis;
	    	Workbook workbook;
	    	try  {
	    		fis = new FileInputStream(filePath);
	    		workbook = new XSSFWorkbook(fis);
	            Sheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet
	            int rowCount = sheet.getPhysicalNumberOfRows()-1;
	            Object[][] emailData = new Object[rowCount][2];
	            
	            int rowNum =1;
	            int index = 0;
	            for (; rowNum <= rowCount; rowNum++) {
	                Row row = sheet.getRow(rowNum);
	                Cell cell = row.getCell(0); // Assuming email addresses are in the first column
	                String email = cell.getStringCellValue();
	                emailData[index][0] = email;
	                cell = row.getCell(1);
	                String pwd = cell.getStringCellValue();
	                emailData[index][1] = pwd;
	                index++;
	            }
	            return emailData;
	        } catch (IOException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
	

}
