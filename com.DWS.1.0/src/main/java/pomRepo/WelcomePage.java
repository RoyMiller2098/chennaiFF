package pomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {

	
	//Using a parameterized constructor driver reference is passed
	//using pF class and iE method the driver reference is passed to the current page/class
	public WelcomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//annotation used instead of driver.findElement
	//element is stored in logLink variable just like repository
	//Using proper getter and setter
	@FindBy(partialLinkText = "Log in")
	private WebElement loginLink;
	
	public WebElement getLoginLink() {
		return loginLink;
	}

	public void setLoginLink(WebElement loginLink) {
		this.loginLink = loginLink;
	}

	public void clickLoginLink() {
		loginLink.click();
	}

}
