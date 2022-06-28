package org.utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	public static ThreadLocal<WebDriver> tlDriver=new ThreadLocal<WebDriver>();
	public static WebDriver initDriver(String bName) {
		if(bName.equalsIgnoreCase("ch")||bName.equalsIgnoreCase("Chrome")) {
			//System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");//Here ./ is root path 
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
		}
		else if (bName.equalsIgnoreCase("ff")||bName.equalsIgnoreCase("FireFox")) {
		//FF
			//System.setProperty("webdriver.gecko.driver","./driver/geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
		}
		else if (bName.equalsIgnoreCase("Ed")||bName.equalsIgnoreCase("Edge")) {
			//Ed
			//System.setProperty("webdriver.edge.driver","./driver/msedgedriver.exe");
			WebDriverManager.edgedriver().setup();
			tlDriver.set(new EdgeDriver());
		}
		else {
			System.out.println("Browser Name is Invalid");
		}
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		return getDriver();
	}
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
}
