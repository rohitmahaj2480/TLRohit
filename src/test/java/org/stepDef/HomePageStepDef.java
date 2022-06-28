package org.stepDef;

import org.appHook.AppHooks;
import org.openqa.selenium.By;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class HomePageStepDef {
	String parentWin;
	@Given("User is on homepage")
	public void user_is_on_homepage() {
		AppHooks.bu.waitForInvisibilityofElement(AppHooks.driver,20,By.linkText("Login"));
		Assert.assertTrue(AppHooks.hp.isactHolderNameDispalay());
		System.out.println("home page Before :"+Thread.currentThread().getId());
	}
	@When("User search product as {string}")
	public void user_search_product_as(String string) {
		AppHooks.hp.serachProduct(string);
		parentWin=AppHooks.driver.getWindowHandle();
	}
	@When("User click on any product from suggested prduct")
	public void user_click_on_any_product_from_suggested_prduct() {
		Assert.assertTrue(AppHooks.plg.isallElementsDisplayed());
		System.out.println("All present");
		AppHooks.bu.waitForVisibilityofElement(AppHooks.driver, 20,By.xpath("(//div[@class='_1AtVbE col-12-12']/div[@class='_13oc-S'])[1]"));
		AppHooks.plg.selectProduct();
	}
	@When("User click on perticular product from suggested prduct")
	public void user_click_on_perticular_product_from_suggested_prduct() {
		AppHooks.bu.waitForVisibilityofElement(AppHooks.driver,20,By.cssSelector("a[title='Wings Of Fire Graphic Novel #02: The Lost Heir (Graphix)']"));
		AppHooks.plg.selectBook();	   
	}
}
