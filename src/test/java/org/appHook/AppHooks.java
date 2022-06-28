package org.appHook;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.utilities.BaseUtilityUpdated;
import org.utilities.DriverFactory;

import Pages.CartPage;
import Pages.HomePage;
import Pages.LoginPageFlip;
import Pages.ProductListPg;
import Pages.ProductPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class AppHooks {
	
	public static WebDriver driver;
	public static LoginPageFlip lf;
	public static HomePage hp;
	public static ProductListPg plg;
	public static ProductPage pp;
	public static CartPage cp;
	public static BaseUtilityUpdated bu;
	@Before 
	public void launchBrowser() {
		DriverFactory df=new DriverFactory();
		driver=df.initDriver("CH");
		lf=new LoginPageFlip(driver);
		bu=new BaseUtilityUpdated();
		hp = new HomePage(driver);
		plg =new ProductListPg(driver);
		pp=new ProductPage(driver);
		cp=new CartPage(driver);
		//WebDriverManager.chromedriver().setup();
		//driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		System.out.println("Before :"+Thread.currentThread().getId());
	}
	@After(order=2)
	public void takeSS(Scenario scn) {
		if(scn.isFailed()) {
		String ssName=scn.getName().replaceAll(" ","");		
		byte[] screenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		scn.attach(screenShot,"img/png",ssName); 
		}	 
	}
	@After(order=1)
	public void tearDown() {
		//driver.close();
	}

}
