package mohanScripts;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericLibrary.BaseTest;
import mohanLibrary.BaseExcel;
import mohanRepository.DemoHomePage;
import mohanRepository.DemoLoginPage;

@Listeners(mohanLibrary.BaseListener.class)
public class testLogIn extends BaseTest{

	@Test(dataProvider = "mohanData")
	public void logIn(String mailId, String password) {
		
		DemoHomePage dhp = new DemoHomePage(driver);
		dhp.loginLinkClick();
		
		DemoLoginPage dlp = new DemoLoginPage(driver);
		dlp.enterMailId(mailId);
		dlp.enterpassword(password);
		dlp.loginButtonClick();
		
	}
	
	@DataProvider(name = "mohanData")
	public Object[][] mohanData() throws IOException {
		
	 Object[][] credentials	= BaseExcel.connectExcell("LogIn");
	 return credentials;
	 
	}

}
