package org.stepDef;

import org.appHook.AppHooks;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductPageStepDef {

	@Then("User is on product page")
	public void user_is_on_product_page() {
		for(String nextWindow:AppHooks.driver.getWindowHandles()) {
			AppHooks.driver.switchTo().window(nextWindow);
		}
		Assert.assertTrue(AppHooks.pp.isaddToCartBtnisDispalyed());
		System.out.println("Before :"+Thread.currentThread().getId());
	}

	@When("User click  on addtocart Button")
	public void user_click_on_addtocart_button() {
		AppHooks.pp.clickOnaddToCart();
		System.out.println("Before :"+Thread.currentThread().getId());
	}

}