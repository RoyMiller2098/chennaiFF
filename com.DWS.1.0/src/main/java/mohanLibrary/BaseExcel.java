package mohanLibrary;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class BaseExcel {

	public static Object[][] connectExcell(String sheetName) throws IOException {
		
		File file = new File("C:\\Users\\kisho\\eclipse-workspace\\com.DWS.1.0\\testdata\\TestData (1).xlsx");
		FileInputStream fis = new FileInputStream(file);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		int rowsize = sheet.getPhysicalNumberOfRows();
		int colsize =  sheet.getRow(0).getPhysicalNumberOfCells();
		
		System.out.println(rowsize);
		System.out.println(colsize);
		
		Object [][] data = new Object[rowsize-1][colsize];
		
		for(int i=1; i<rowsize; i++) {
			for(int j=0; j<colsize; j++) {
				data [i-1][j] = sheet.getRow(i).getCell(j).toString();
			}
		}
		
		return data;
		
	}

}
