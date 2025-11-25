package StepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Pages.SearchPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchPageStepDefinitions 
{
	private static final Logger logger = LogManager.getLogger(SearchPageStepDefinitions.class);
	WebDriver driver;
	SearchPage search;
	public SearchPageStepDefinitions() 
	{
	    driver = Hooks.driver;
	    search = new SearchPage(driver);
	}

	@When("the user types {string} in the search box")
	public void the_user_types_in_the_search_box(String productName)
	{
	  search.SearchProductMethod(productName);
	}

	@When("clicks on the search button")
	public void clicks_on_the_search_button() 
	{
	    search.SimpleSearchButtonClick();
	}

	@Then("the search results page should display products related to {string}")
	public void the_search_results_page_should_display_products_related_to(String expectedURL) 
	{
	   String ActualUrl=driver.getCurrentUrl();
	   Assert.assertTrue(ActualUrl.contains(ActualUrl), "This is not an Product Page");
	}

	@Then("the auto-suggestion list \\(if any) should show {string} or similar items")
	public void the_auto_suggestion_list_if_any_should_show_or_similar_items(String expectedText) 
	{
		 boolean result = search.verifyAutoSuggestionContains(expectedText);
		    Assert.assertTrue(result, "Expected auto-suggestion containing: " + expectedText);
		    logger.info("Auto suggestion items are present: {}", result);
	}

	@When("the user searches for {string}")
	public void the_user_searches_for(String ProductName)
	{
	   search.SearchProductFunctionality(ProductName);
	}

	@Then("the user should see {string} \\(or equivalent)")
	public void the_user_should_see_or_equivalent(String expectedText) 
	{
		 boolean result = search.NoProductFoundMethod(expectedText);
		    Assert.assertTrue(result, expectedText);
		    logger.info("No search product found on webpage: {}", result);
	}
	
	
	@Then("either no results or a validation message should appear {string}")
	public void either_no_results_or_a_validation_message_should_appear(String expectedText) 
	{
		 boolean result = search.NoProductFoundMethod(expectedText);
		    Assert.assertTrue(result, expectedText);
		    logger.info("No search product found on webpage: {}", result);
	}
}
