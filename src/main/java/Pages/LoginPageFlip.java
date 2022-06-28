package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFlip {

	//WebElements
	WebDriver driver;
	@FindBy(linkText="Login")
	private WebElement loginButton;
	@FindBy(xpath="(//input[@type='text'])[2]")
	private WebElement uNameInputField;
	
	@FindBy(css="[type='password']")
	private WebElement pwdInputField;
	
	@FindBy(xpath="(//button[@type='submit'])[2]")
	private WebElement submitButton;
	
	//Initializing variable (WebElements)
	public LoginPageFlip(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public boolean verifyLoginPage() {
		//loginButton.click();
		return uNameInputField.isDisplayed();
		
	}
		public void doLogin() {
		//loginButton.click();
		uNameInputField.sendKeys("9594623769");
		pwdInputField.sendKeys("Rohit@241095");
		submitButton.click();
		
	}
	
	
	
	
}
