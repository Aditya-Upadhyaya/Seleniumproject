package com.tutorialsninja.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCart {
	public ShoppingCart(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Checkout")
	public static WebElement checkout;

    public static void navigateToCheckOutpage() {
    	checkout.click();
    }
}

