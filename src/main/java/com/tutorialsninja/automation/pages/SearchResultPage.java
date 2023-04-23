package com.tutorialsninja.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {

	public SearchResultPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(linkText = "Samsung SyncMaster 941BW")
	public static WebElement samsungSyncMaster;
	
	@FindBy(xpath = "//p[text() = \"There is no product that matches the search criteria.\"]")
	public static WebElement applemessage;
	
	@FindBy(xpath = "//span[text()=\"Add to Cart\"][1]")
	public static WebElement addtocart;
}
