package org.utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Generic_Method {

	WebDriver driver;
	WebDriverWait wt;
	
	public WebDriver startup(String url ,String bName,int time) {

		if(bName.equalsIgnoreCase("CH")||bName.equalsIgnoreCase("Chrome Browser")){
			System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
			driver =new ChromeDriver();//Upcasting

		}else if (bName.equalsIgnoreCase("FF")||bName.equalsIgnoreCase("FireFox Browser")) {
			System.setProperty("webdriver.gecko.driver","./.driver/geckodriver.exe");
			driver=new FirefoxDriver();

		}else if(bName.equalsIgnoreCase("ED")|| bName.equalsIgnoreCase("Edge Browser")) {
			System.setProperty("webdriver.edge.driver.","./driver/msedgedriver.exe");
			driver=new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}
	//Generic Methods
	
	public void waitForVisibilityOfElement(WebDriver driver,int time ,By locator) {
	wt=new WebDriverWait(driver,Duration.ofSeconds(time));
	wt.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	public void waitForInvisibilityOfElement(WebDriver driver,int time ,By locator) {
	wt=new WebDriverWait(driver,Duration.ofSeconds(time));
	wt.until(ExpectedConditions.invisibilityOfElementLocated(locator));	
	}
	public void waitForElementToBeClickable(WebDriver driver,int time ,By locator) {
	wt=new WebDriverWait(driver,Duration.ofSeconds(time));
	wt.until(ExpectedConditions.elementToBeClickable(locator));	
	}
	public void waitForElementToBeSelected(WebDriver driver,int time ,By locator) {
	wt=new WebDriverWait (driver,Duration.ofSeconds(time));
	wt.until(ExpectedConditions.elementToBeSelected(locator));
	}
	public void waitForPresenceOfElement(WebDriver driver,int time ,By locator) {
	wt= new WebDriverWait (driver,Duration.ofSeconds(time));
	wt.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	
}
