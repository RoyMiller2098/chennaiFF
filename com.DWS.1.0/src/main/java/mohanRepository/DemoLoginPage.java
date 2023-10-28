package mohanRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoLoginPage {

	public DemoLoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "Email")
	static WebElement emailTextField;
	
	public static void enterMailId(String emailId) {
		emailTextField.sendKeys(emailId);
	}
	
	@FindBy(id = "Password")
	static WebElement passwordTextField;
	
	public static void enterpassword(String password) {
		passwordTextField.sendKeys(password);
	}
	
	@FindBy(xpath = "//input[@value=\"Log in\"]")
	static WebElement loginButton;
	
	public static void loginButtonClick() {
		loginButton.click();
	}
}