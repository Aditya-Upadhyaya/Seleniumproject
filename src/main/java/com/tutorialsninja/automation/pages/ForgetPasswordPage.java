package com.tutorialsninja.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgetPasswordPage {

	public ForgetPasswordPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "input-email")
	public static WebElement emailField;
	
	@FindBy(xpath = "//input[@value=\"Continue\"]")
	public static WebElement continueButton;
}
