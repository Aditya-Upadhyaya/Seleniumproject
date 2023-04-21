package com.tutorialsninja.automation.stepdef;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.tutorialsninja.automation.base.Base;
import com.tutorialsninja.automation.pages.AccountPage;
import com.tutorialsninja.automation.pages.Header;
import com.tutorialsninja.automation.pages.RegisterPage;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class register {
	
	public WebDriver driver = Base.driver;
	public Header head = new Header(Base.driver);
	public RegisterPage registerPage = new RegisterPage(Base.driver);
	public AccountPage accountpage = new AccountPage(Base.driver);
	
	@Given("^I launch the application$")
	public void i_launch_the_application() {
		Base.driver.get("http://www.tutorialsninja.com/demo/");
	}

	@And("^I navigate to Account Registration page$")
	public void i_navigate_to_Account_Registration_page() {
		
	
		Header.myaccount.click();
		Header.register.click();
	    
	}

	
	@When("^I provide all the below valid details$")
	public void i_provide_all_the_below_valid_details(DataTable arg1)   {
	    
		RegisterPage.enteralldetails(arg1, "no");
		
	}

	@And("^I select the Privacy Policy$")
	public void i_select_the_Privacy_Policy()  {
	    
		RegisterPage.checkBox.click();
	}

	@And("^I click on Continue button$")
	public void i_click_on_Continue_button()  {
		RegisterPage.continuElement.click();
	}

	@Then("^I should see that the User Account has successfully created$")
	public void i_should_see_that_the_User_Account_has_successfully_created() {
		
	   Assert.assertTrue(AccountPage.success.isDisplayed());
	   
	}
	@Then("^I should see that the User Account is not created$")
	public void i_should_see_that_the_User_Account_is_not_created()  {
		 Assert.assertTrue(RegisterPage.registerElement.isDisplayed());
		   
	}

	@And("^I should see the error messages informing the user to fill the mandatory fields$")
	public void i_should_see_the_error_messages_informing_the_user_to_fill_the_mandatory_fields()  {
		
		Assert.assertTrue(RegisterPage.firstnameWarning.isDisplayed());
		Assert.assertTrue(RegisterPage.lastnameWarning.isDisplayed());
		Assert.assertTrue(RegisterPage.emailWarning.isDisplayed());
		Assert.assertTrue(RegisterPage.telephoneWarning.isDisplayed());
		Assert.assertTrue(RegisterPage.passwordWarning.isDisplayed());
		Assert.assertTrue(RegisterPage.mainwarning.isDisplayed());
		
	}

	@And("^I subscribe to Newsletter$")
	public void i_subscribe_to_Newsletter()  {
		RegisterPage.newsletter.click();
		   
	}
	@When("^I provide the below duplicate details into the fields$")
	public void i_provide_the_below_duplicate_details_into_the_fields(DataTable arg1) {
		RegisterPage.enteralldetails(arg1, "duplicate");
	}

	@Then("^I should see the warning message stating that the user is already created$")
	public void i_should_see_the_warning_message_stating_that_the_user_is_already_created() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals("Warning: E-Mail Address is already registered!", RegisterPage.emailalreadyWarning.getText());
	}

	

}
