package testScriptsYogitha;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import genericLibrary.BaseTest;
import genericLibrary.Excel;

@Listeners(genericLibrary.Listener.class)
public class LoginTest extends BaseTest{

	@Test(dataProvider = "dataLogin")
	public void logIn(String mailId, String password) {
		
		driver.findElement(By.xpath("//a[text()='Log in']")).click();
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(mailId);
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
	}
	
	@DataProvider(name="dataLogin")
	public Object[][] dataToLogin() throws EncryptedDocumentException, IOException {
		
		Object [][]credentials =Excel.logInData("LogIn");
		return credentials;
	}
}
