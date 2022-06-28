package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	WebDriver driver;
	@FindBy(css="button[class='_2KpZ6l _2U9uOA _3v1-ww']")
	private WebElement addToCartBtn;
	
	
	public ProductPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public boolean isaddToCartBtnisDispalyed() {
		return addToCartBtn.isDisplayed();
	}
	
	public void clickOnaddToCart() {
		addToCartBtn.click();
	}
	
}


