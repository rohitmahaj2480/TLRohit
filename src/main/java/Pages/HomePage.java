package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	@FindBy(xpath="(//div[@class='exehdJ'])[1]")
	private WebElement actHolderName;
	@FindBy(name="q")
	private WebElement searchFiled;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	public boolean isactHolderNameDispalay() {
		return actHolderName.isDisplayed();
	}
	public void serachProduct(String Product) {
		searchFiled.sendKeys(Product);
		searchFiled.sendKeys(Keys.ENTER);
	}
	
}
