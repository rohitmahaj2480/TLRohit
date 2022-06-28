package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utilities.BaseUtilityUpdated;

public class ProductListPg {
	WebDriver driver;
	BaseUtilityUpdated bu;
	@FindBy(xpath="//div[@class='_1AtVbE col-12-12']/div[@class='_13oc-S']")
	private List<WebElement> all24Products;
	
	@FindBy(xpath="(//div[@class='_1AtVbE col-12-12']/div[@class='_13oc-S'])[1]")
	private WebElement firstProduct;
	
	@FindBy(css="a[title='Wings Of Fire Graphic Novel #02: The Lost Heir (Graphix)']")
	private WebElement pertiBook;

	public ProductListPg(WebDriver driver) {	
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	public boolean isallElementsDisplayed() {
		if(all24Products.size()==24) {
			return true;
		}else {
			return false;
		}
	}

	public void selectProduct() {
		Actions act = new Actions(driver);
		act.moveToElement(firstProduct).click().perform();

	}
	
	public void selectBook() {
		Actions act = new Actions(driver);
		act.moveToElement(pertiBook).click().perform();
	}


}
