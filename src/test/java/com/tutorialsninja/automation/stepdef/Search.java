package com.tutorialsninja.automation.stepdef;

import org.junit.Assert;

import com.tutorialsninja.automation.base.Base;
import com.tutorialsninja.automation.pages.Header;
import com.tutorialsninja.automation.pages.SearchResultPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Search {
	public SearchResultPage sr= new SearchResultPage(Base.driver); 
	
	@When("^I search for a product \"([^\"]*)\"$")
	public void i_search_for_a_product(String arg1)  {
	    Header.searchbox.sendKeys(arg1);
	    Header.searchButton.click();
	}

	@Then("^I should see the product in the search resultsil address$")
	public void i_should_see_the_product_in_the_search_resultsil_address() {
	    Assert.assertTrue(SearchResultPage.samsungSyncMaster.isDisplayed());
	}
	@Then("^I should see the page displaying the message \"([^\"]*)\"$")
	public void i_should_see_the_page_displaying_the_message(String arg1) {
	    Assert.assertEquals(arg1, SearchResultPage.applemessage.getText());
	}


}
