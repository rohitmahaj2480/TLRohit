Feature: Verify Details on cart Page

Background:
					Given User is on login page
					When User do login
@Regression					 
Scenario Outline: Verify that when user clicks on add to cart, the product should be added to cart
				Given User is on homepage
				When User search product as "<Product>"
				And User click on any product from suggested prduct
				Then User is on product page 
				When User click  on addtocart Button
				Then User is redirected on the cart page
Examples: 
|Product|
|Mobile|
|Tv| 	
@Smoke
Scenario Outline: Verify that when user clicks on add to cart, the product should be added to cart
				Given User is on homepage
				When User search product as "<Product>"
				And User click on perticular product from suggested prduct
				Then User is on product page 
				When User click  on addtocart Button
				Then User is redirected on the cart page
				
Examples:
|Product|
|Wings of Fire|


 		