package extentReports;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class LearningExtentReports {

	static WebDriver driver;
	
	public static void main(String[] args) {

		ExtentSparkReporter reporter = new ExtentSparkReporter("./reports/firstReport.html");
		ExtentReports report = new ExtentReports();
		report.attachReporter(reporter);
		ExtentTest test = report.createTest("LoginTest");

		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demowebshop.tricentis.com/");
		driver.findElement(By.xpath("//a[text()='Log in']")).click();
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("kannanm@gmail.com");
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("pple@2345");//Fail script on purpose(password : "apple@2345")
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		
		//Script completion validation - isDisplayed
		//If not displayed - we print status and get screenshot of failure and display it in the report
		try{
			if(driver.findElement(By.className("ico-logout")).isDisplayed()) {
				System.out.println("pass: User is logged in! ");
				test.log(Status.PASS, "Logged in ");

			}
		}catch(Exception e) {
			System.out.println("failed: user is not logged in! ");
			test.log(Status.FAIL, "Not logged in ");
			test.fail(MediaEntityBuilder.createScreenCaptureFromPath(getScreenShot()).build());
		}

		driver.quit();
		report.flush();

	}
	
	//This method takes screenshot when invoked
	//It returns the path of the screenshot in the form of string @return
	public static String getScreenShot() {
		
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
		
		return "."+path;//for correct path in reports and for not to get broken image
	}

}
