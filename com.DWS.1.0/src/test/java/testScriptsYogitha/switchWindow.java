package testScriptsYogitha;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import genericLibrary.BaseTest;

public class switchWindow extends BaseTest{


	@Test
	public void switchToWindow() throws InterruptedException {

		driver.findElement(By.xpath("//a[text()='Twitter']")).click();
		switchToo("twitter");

	}
}


