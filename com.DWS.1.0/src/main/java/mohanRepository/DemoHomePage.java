package mohanRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoHomePage {

	public DemoHomePage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[text()=\"Log in\"]")
	public static WebElement loginLink;
	
	public static void loginLinkClick() {
		loginLink.click();
	}
	
}
