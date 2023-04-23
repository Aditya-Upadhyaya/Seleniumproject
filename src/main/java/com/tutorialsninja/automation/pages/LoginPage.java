package com.tutorialsninja.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tutorialsninja.automation.base.Base;

public class LoginPage {
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "input-email")
	public static WebElement emailfield;
	
	@FindBy(id = "input-password")
	public static WebElement passwordfield;
	
	@FindBy(css = "input[type=\"submit\"]")
	public static WebElement submitbutton;
	
	@FindBy(css = "div.alert-dismissible.alert")
	public static WebElement alertElement;
	
	@FindBy(linkText = "Forgotten Password")
	public static WebElement forgetPassword;
	
	@FindBy(css = "div[class*='alert']")
	public static WebElement mainwarning;
	
	@FindBy(xpath = "//input[@value=\"Login\"]")
	public static WebElement logIn;
	
	public static void doLogin(String arg1, String arg2) {
		LoginPage.emailfield.sendKeys(arg1);
		LoginPage.passwordfield.sendKeys(arg2);
		LoginPage.submitbutton.click();	
		
	}
	
	public static void doLogin() {
		Header.myaccount.click();
		Header.loginIn.click();
		emailfield.sendKeys(Base.prop.getProperty("username"));
		passwordfield.sendKeys(Base.prop.getProperty("pass"));
		LoginPage.logIn.click();
	}
}
