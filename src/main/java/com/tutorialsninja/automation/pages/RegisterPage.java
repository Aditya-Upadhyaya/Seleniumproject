package com.tutorialsninja.automation.pages;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.DataTable;

public class RegisterPage {
	public RegisterPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="input-firstname")
	public static WebElement firstName;
		
	@FindBy(id="input-lastname")
	public static WebElement lastName;
		
	@FindBy(id="input-email")
	public static WebElement email;
		
	@FindBy(id="input-telephone")
	public  static WebElement telephone;
		
	@FindBy(id="input-password")
	public static WebElement password;
		
	@FindBy(id="input-confirm")
	public static WebElement confirmPassword;
	
	@FindBy(name = "agree")
	public static WebElement checkBox;
	
	@FindBy(xpath = "//input[@value = \"Continue\"]")
	public static WebElement continuElement;
	
	@FindBy(linkText = "Register")
	public static WebElement registerElement;
	
	@FindBy(css="input[id='input-firstname']+div")
	public static WebElement firstnameWarning;
	
	@FindBy(css="input[id='input-lastname']+div")
	public static WebElement lastnameWarning;
	
	@FindBy(css="input[id='input-email']+div")
	public static WebElement emailWarning;
	
	@FindBy(css="input[id='input-telephone']+div")
	public static WebElement telephoneWarning;
	
	@FindBy(css="input[id='input-password']+div")
	public static WebElement passwordWarning;
	
	@FindBy(xpath = "//div[text() = \"Warning: You must agree to the Privacy Policy!\"]")
	public static WebElement mainwarning;
	
	@FindBy(xpath = "//input[@name= \"newsletter\" and @value=\"1\"]")
	public static WebElement newsletter;
	
	@FindBy(xpath = "//div[text() = \"Warning: E-Mail Address is already registered!\"]")
	public static WebElement emailalreadyWarning;
	
	public static void enteralldetails(DataTable arg1, String type) {
		Map<String, String> map = arg1.asMap(String.class, String.class);
		firstName.sendKeys(map.get("FirstName"));
		lastName.sendKeys(map.get("LastName"));
		telephone.sendKeys(map.get("Telephone"));
		password.sendKeys(map.get("Password"));
		confirmPassword.sendKeys(map.get("Password"));
		
		if (type.equalsIgnoreCase("duplicate")) {
			email.sendKeys(map.get("Email"));
		} else {
			email.sendKeys(System.currentTimeMillis()+map.get("Email")); 
		}
	}
	
}
