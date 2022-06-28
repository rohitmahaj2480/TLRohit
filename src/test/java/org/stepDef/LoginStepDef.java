package org.stepDef;

import java.util.Iterator;
import java.util.Set;

import org.appHook.AppHooks;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.utilities.BaseUtilityUpdated;
import org.utilities.DriverFactory;

import Pages.CartPage;
import Pages.HomePage;
import Pages.LoginPageFlip;
import Pages.ProductListPg;
import Pages.ProductPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginStepDef {
	//WebDriver driver;
	//DriverFactory df =new DriverFactory();
	@Given("User is on login page")
	public void user_is_on_login_page() {
		//driver=df.getDriver();
		AppHooks.bu.waitForVisibilityofElement(AppHooks.driver,20,By.xpath("(//input[@type='text'])[2]"));
		Assert.assertTrue(AppHooks.lf.verifyLoginPage());
	}

//	@When("User do login")
//	public void user_do_login() {
//		AppHooks.lf.doLogin();
//		System.out.println("login Before :"+Thread.currentThread().getId());  
//	}	
}
