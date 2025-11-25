package StepDefinitions;
import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Constants.FrameWorkConstants;
import Pages.HomePage;
import Utils.ConfigReaderUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageStepDefinitions 
{
	private static final Logger logger = LogManager.getLogger(HomePageStepDefinitions.class);
	WebDriver driver;
	HomePage home;
	ConfigReaderUtils config;
	@Given("the user opens the web shop home page")
	public void the_user_opens_the_web_shop_home_page() throws IOException 
	{
		driver=Hooks.driver;
	    config=new ConfigReaderUtils(FrameWorkConstants.Config_Path);
	    String Url=config.getValue("url");
	    driver.get(Url);
	    home=new HomePage(driver);
	}

	@Then("the homepage title should be {string}")
	public void the_homepage_title_should_be(String ExpectedHomePageTitle)
	{
	  String ActualTitle= driver.getTitle();
	  Assert.assertTrue(ActualTitle.equalsIgnoreCase(ExpectedHomePageTitle), "HomePage Title Mismatch");
	}

	@Then("main categories like {string}, {string}, {string}, {string}, etc should be visible")
	public void main_categories_like_etc_should_be_visible(String books, String computers, String electronics, String ApparelAndShoes) throws InterruptedException
	{
		 List<String> categories = home.GetCatgoryList();
		 logger.info("Categories found on page: {}", categories);

		 // Convert all categories to UPPERCASE to compare easily
		 String allCategoriesUpper = categories.toString().toUpperCase();
		 
		 Assert.assertTrue(allCategoriesUpper.contains(books.toUpperCase()), books + " category NOT found! Available: " + categories);
		 Assert.assertTrue(allCategoriesUpper.contains(computers.toUpperCase()), computers + " category NOT found! Available: " + categories);
		 Assert.assertTrue(allCategoriesUpper.contains(electronics.toUpperCase()), electronics + " category NOT found! Available: " + categories);
		 Assert.assertTrue(allCategoriesUpper.contains(ApparelAndShoes.toUpperCase()), ApparelAndShoes + " category NOT found! Available: " + categories);
	}

	@Given("the user is on the homepage")
	public void the_user_is_on_the_homepage() throws IOException 
	{
		driver=Hooks.driver;
	    config=new ConfigReaderUtils(FrameWorkConstants.Config_Path);
	    String Url=config.getValue("url");
	    driver.get(Url);
	    home=new HomePage(driver);
	}

	@When("the user clicks on the {string} category link")
	public void the_user_clicks_on_the_category_link(String Category) 
	{
	  home.ClickOnCategoryOptionBasedOnParamter(Category);
	}

	@Then("the Books category page should be displayed")
	public void the_books_category_page_should_be_displayed() 
	{
	    String url=driver.getCurrentUrl();
	    Assert.assertTrue(url.contains("books"), "Books Category page not displayed");
	}

	@Then("the search textbox should be visible")
	public void the_search_textbox_should_be_visible() 
	{
	   Assert.assertTrue(home.newLetterEmail.isDisplayed(), "Newsletter Search Box not Visible");
	}

	@Then("the search button should be visible")
	public void the_search_button_should_be_visible() 
	{
	    Assert.assertTrue(home.subscribeButton.isDisplayed(), "Search Button not visible");
	}

}
