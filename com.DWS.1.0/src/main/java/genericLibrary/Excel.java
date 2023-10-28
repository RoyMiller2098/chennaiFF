package genericLibrary;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel {

	public static Object[][] logInData(String sheetName) throws EncryptedDocumentException, IOException {
		
		File file=new File("C:\\Users\\kisho\\eclipse-workspace\\com.DWS.1.0\\testdata\\TestData (1).xlsx");
		FileInputStream fl=new FileInputStream(file);
		Workbook workbook=WorkbookFactory.create(fl);
		Sheet sheet=workbook.getSheet(sheetName);
		int rowsize=sheet.getPhysicalNumberOfRows();
		int colsize=sheet.getRow(0).getPhysicalNumberOfCells();
		
		System.out.println(rowsize);
		System.out.println(colsize);
		
		Object [][] data=new Object[rowsize-1][colsize];
		
		for(int i=1; i<rowsize; i++) {
			for(int j=0; j<colsize; j++) {
				data[i-1][j]=sheet.getRow(i).getCell(j).toString();
			}
		}
		
		return data;
		
		}
}
