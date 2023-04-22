package com.tutorialsninja.automation.stepdef;

import org.junit.Assert;

import com.tutorialsninja.automation.base.Base;
import com.tutorialsninja.automation.pages.ForgetPasswordPage;
import com.tutorialsninja.automation.pages.Header;
import com.tutorialsninja.automation.pages.LoginPage;
import com.tutorialsninja.automation.pages.MyAccountPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Login {
	public MyAccountPage acc = new MyAccountPage(Base.driver);
	public LoginPage log = new LoginPage(Base.driver);
	public ForgetPasswordPage forg = new ForgetPasswordPage(Base.driver);

	@Given("^I naviage to Account Login page$")
	public void i_naviage_to_Account_Login_page(){
		Header.myaccount.click();
	    Header.loginIn.click();
	}

	@When("^I login to the application using Username \"([^\"]*)\" and Password \"([^\"]*)\"$")
	public void i_login_to_the_application_using_Username_and_Password(String arg1, String arg2)  {
	    
		LoginPage.doLogin(arg1, arg2);
	}

	@Then("^I should see that the User is able to successfully login$")
	public void i_should_see_that_the_User_is_able_to_successfully_login()  {
	    
	    Assert.assertTrue(MyAccountPage.registerAffiliate.isDisplayed());
	}
	@Then("^I should see an error message informing the User about invalid credentials$")
	public void i_should_see_an_error_message_informing_the_User_about_invalid_credentials()  {
		Assert.assertTrue(LoginPage.alertElement.isDisplayed());
	}

	@When("^I reset the forgotten password for \"([^\"]*)\"$")
	public void i_reset_the_forgotten_password_for(String arg1)  {
	    LoginPage.forgetPassword.click();
	    ForgetPasswordPage.emailField.sendKeys(arg1);
	    ForgetPasswordPage.continueButton.click();
	    
	}

	@Then("^I should see a message informing that the password reset details have been sent to the email address$")
	public void i_should_see_a_message_informing_that_the_password_reset_details_have_been_sent_to_the_email_address()  {
	 
		Assert.assertEquals("An email with a confirmation link has been sent your email address.",LoginPage.mainwarning.getText());
	}

}
