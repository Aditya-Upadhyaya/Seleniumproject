package com.tutorialsninja.automation.stepdef;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tutorialsninja.automation.base.Base;
import com.tutorialsninja.automation.pages.CheckoutPage;
import com.tutorialsninja.automation.pages.Header;
import com.tutorialsninja.automation.pages.LoginPage;
import com.tutorialsninja.automation.pages.OrderSucessPage;
import com.tutorialsninja.automation.pages.SearchResultPage;
import com.tutorialsninja.automation.pages.ShoppingCart;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Order {
	
	public Header head = new Header(Base.driver);
	public LoginPage log = new LoginPage(Base.driver);
	public SearchResultPage ar = new SearchResultPage(Base.driver);
	public ShoppingCart sh = new ShoppingCart(Base.driver);
	public CheckoutPage ch = new CheckoutPage(Base.driver);
	public OrderSucessPage or = new OrderSucessPage(Base.driver);
	
	@Given("^I login to the application$")
	public void i_login_to_the_application()  {
		Base.driver.get(Base.prop.getProperty("url"));
		LoginPage.doLogin();
		
		
	}

	@When("^I add any product to Bag and checkout$")
	public void i_add_any_product_to_Bag_and_checkout() throws InterruptedException  {
	    Header.searchbox.sendKeys(Base.prop.getProperty("product"));
	    Header.searchButton.click();
	    SearchResultPage.addtocart.click();
	    Thread.sleep(3000);
	    Header.navigateToShoppingcart();
	    ShoppingCart.navigateToCheckOutpage();
	}

	@When("^I place an order$")
	public void i_place_an_order() {
		
		CheckoutPage.placeOrder();
	    
	}

	@Then("^I should see that the order is placed successfully$")
	public void i_should_see_that_the_order_is_placed_successfully() {
		WebDriverWait wait = new WebDriverWait(Base.driver,10);
		wait.until(ExpectedConditions.visibilityOf(OrderSucessPage.sucessElement));
	    Assert.assertTrue(OrderSucessPage.sucessElement.isDisplayed());
	}

}
