package genericLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	private Workbook wb;
	
	public void excelInitialization(String excelPath)  {
		FileInputStream fis= null;
	    
		try {
			fis = new FileInputStream(excelPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			wb = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException | IOException e) {
			e.printStackTrace();
		}
	}
	public String readData(String sheetName, int rowNum, int cellNum) {
		return wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
	}
	public Map<String,String> readData(String sheetName)
	{
		Map<String,String> map = new HashMap<>();
		Sheet sh = wb.getSheet(sheetName);
		for(int i=0;i<=sh.getLastRowNum();i++)
		{
			Cell cell = sh.getRow(i).getCell(0);
			String key = cell.getStringCellValue();
			String value = cell.getStringCellValue()
;		}
		return map;
	}
	public void closeWorkbook()
	{
		try {
			wb.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
