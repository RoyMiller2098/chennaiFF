package genericLibrary;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Set;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilityMethods {

	public static WebDriver driver;
	public Select select;
	public Actions action;
	public WebDriverWait wait;

	public void initObjects() {
		action = new Actions(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public static void getScreenShot() {

		LocalDateTime dt = LocalDateTime.now();
		String datetime = dt.toString().replaceAll(":","-");
		String path = "./screeenshot/"+datetime+".png";
		TakesScreenshot ts = (TakesScreenshot) driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(path);
		try {

			FileHandler.copy(temp, dest);

		} catch (IOException e) {

			System.out.println("Failed to take screenshot! ");
		}

	}
	
	public void selectt(Object index, String value,String text) {
		
		if( index != null ) {
			System.out.println();
		}
		else if(value != null) {
			
		}
		else {
			
		}
	}
	
	public void switchToo(String title) throws InterruptedException {
		
		
		String parentWindowHandle = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		windowHandles.remove(parentWindowHandle);
		for(String i:windowHandles) {
			Thread.sleep(5000);
			driver.switchTo().window(i);
			if(driver.getTitle().contains(title)) {
				break;
			}
			
		}
		driver.close();

	}

}
