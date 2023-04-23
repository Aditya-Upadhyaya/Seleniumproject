package com.tutorialsninja.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class Header {
	public Header(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='My Account']")
	public static WebElement myaccount;

	@FindBy(linkText = "Register")
	public static WebElement register;

	@FindBy(linkText = "Login")
	public static WebElement loginIn;
	
	@FindBy(name = "search")
	public static WebElement searchbox;
	
	@FindBy(css="button[class*=\"btn-default\"]")
	public static WebElement searchButton;
	
	@FindBy(xpath = "//span[text()=\"Shopping Cart\"]")
	public static WebElement shoppingcart;
	
	public static void navigateToShoppingcart() {
		shoppingcart.click();
	}
}
