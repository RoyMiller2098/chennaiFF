package pomRepo;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import genericLibrary.BaseTest;
import genericLibrary.Excel;


public class LogIn extends BaseTest{

	@Test(dataProvider = "dataLogin")
	public void logIn(String mailId, String password) {
		
		WelcomePage welcomePage = new WelcomePage(driver);
		welcomePage.clickLoginLink();
		
		LoginPage logpg = new LoginPage(driver);
		logpg.enterEmail(mailId);
		logpg.passwordTextField.sendKeys(password);
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
	}
	
	@DataProvider(name="dataLogin")
	public Object[][] dataToLogin() throws EncryptedDocumentException, IOException {
		
		Object [][]credentials =Excel.logInData("LogIn");
		return credentials;
	}
}
