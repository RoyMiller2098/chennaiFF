package testScriptsYogitha;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericLibrary.BaseTest;

public class RegisterTest extends BaseTest{

	@Test(dataProvider = "registerTestData")
	public void register(String firstName,String lastName, String mailId, String password, String confirmPassword) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demowebshop.tricentis.com/");
		Thread.sleep(2000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement regl = driver.findElement(By.xpath("//a[text()='Register']"));
		regl.click();
		WebElement gender = driver.findElement(By.xpath("//input[@id='gender-male']"));
		wait.until(ExpectedConditions.visibilityOf(gender));
		gender.click();

		WebElement fname = driver.findElement(By.xpath("//input[@id='FirstName']"));
		wait.until(ExpectedConditions.visibilityOf(fname));
		fname.sendKeys(firstName);

		WebElement lname = driver.findElement(By.xpath("//input[@id='LastName']"));
		wait.until(ExpectedConditions.visibilityOf(lname));
		lname.sendKeys(lastName);

		WebElement email = driver.findElement(By.xpath("//input[@id='Email']"));
		wait.until(ExpectedConditions.visibilityOf(email));
		email.sendKeys(mailId);

		WebElement pwrd = driver.findElement(By.xpath("//input[@id='Password']"));
		wait.until(ExpectedConditions.visibilityOf(pwrd));
		pwrd.sendKeys(password);

		WebElement cpwrd = driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
		wait.until(ExpectedConditions.visibilityOf(cpwrd));
		cpwrd.sendKeys(confirmPassword);

		driver.close();

	}


	@DataProvider(name = "registerTestData")
	public Object[][] registerTestData() {

		Object [][] data=new Object[2][5];

		//UserName and Password : 2 sets of data
		data[0][0]="firstName1";
		data[0][1]="lastName1";
		data[0][2]="mailId1";
		data[0][3]="password1";
		data[0][4]="confirmPassword1";
		data[1][0]="firstName2";
		data[1][1]="lastName2";
		data[1][2]="mailId2";
		data[1][3]="password2";
		data[1][4]="confirmPassword2";

		return data;
	}

}
