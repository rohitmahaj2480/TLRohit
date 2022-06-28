package org.stepDef;

import org.appHook.AppHooks;
import org.testng.Assert;
import org.testng.Reporter;

import io.cucumber.java.en.Then;

public class CartStepDef {
	@Then("User is redirected on the cart page")
	public void user_is_redirected_on_the_cart_page() {

		Assert.assertTrue(AppHooks.cp.isplaceOrderbtnDispalyed());
		Reporter.log("Items Added Succesfully in cart");

	}
}
