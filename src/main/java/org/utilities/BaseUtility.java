package org.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseUtility {
	WebDriver obj ;  //null
	//webdriver is interface and implemented in remotedriver class and remotedriver class is 
	//extended in chromedriver,firefoxdriver,edgedriver class etc...
	//to remove code reduduncy  and upacasting we are declaring refernce of webdriver interface. 


	public  void startup(String bName,String url) {
		if(bName.equalsIgnoreCase("ch")||bName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");//Here ./ is root path 
			//ChromeDriver objCH  = new ChromeDriver(); //ctrl+shift+o to import class
			//objCH.get(url);
			obj = new ChromeDriver(); //up_casting and declaring obj here
			//object of parent interface is behave as child class object
		}
		else if (bName.equalsIgnoreCase("ff")||bName.equalsIgnoreCase("FireFox")) {
			//FF
			System.setProperty("webdriver.gecko.driver","./driver/geckodriver.exe");
			//FirefoxDriver objFF = new FirefoxDriver();
			//objFF.get(url);
			obj=new FirefoxDriver();
		}
		else if (bName.equalsIgnoreCase("Ed")||bName.equalsIgnoreCase("Edge")) {
			//Ed
			System.setProperty("webdriver.edge.driver","./driver/msedgedriver.exe");
			EdgeDriver objED = new EdgeDriver();
			objED.get(url);

			obj = new EdgeDriver();
		}
		else {
			System.out.println("Browser Name is Invalid");
		}
		obj.get(url);

	}

}


