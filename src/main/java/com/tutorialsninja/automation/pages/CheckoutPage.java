package com.tutorialsninja.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

	public CheckoutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "input-payment-firstname")
	public static WebElement firstname;
	
	@FindBy(id = "input-payment-lastname")
	public static WebElement lastname;
	
	@FindBy(id = "input-payment-address-1")
	public static WebElement address;
	
	@FindBy(id = "input-payment-city")
	public static WebElement city;
	
	@FindBy(id = "input-payment-postcode")
	public static WebElement postcode;
	
	@FindBy(id = "input-payment-zone")
	public static WebElement state;
	
	@FindBy(id = "input-payment-country")
	public static WebElement country;

	@FindBy(id = "button-payment-address")
	public static WebElement continueBilling;
	
	@FindBy(id = "button-shipping-address")
	public static WebElement continueDelivery;

	@FindBy(id = "button-shipping-method")
	public static WebElement continueDeliveryMethod;
	
	@FindBy(xpath = "//input[@name=\"agree\"]")
	public static WebElement checkBox;
	
	@FindBy(id = "button-payment-method")
	public static WebElement continuePayment;
	
	@FindBy(id = "button-confirm")
	public static WebElement confirmButton;
	
	@FindBy(linkText = "Success")
	public static WebElement success;
	
	public static void placeOrder() {
		continueBilling.click();
		continueDelivery.click();
		continueDeliveryMethod.click();
		checkBox.click();
		continuePayment.click();
		confirmButton.click();
	}
}
