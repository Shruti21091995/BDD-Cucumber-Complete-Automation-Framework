package StepDefinitions;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import Constants.FrameWorkConstants;
import Pages.LoginLinkPage;
import Utils.ConfigReaderUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginLinkStepDefinitions 
{
	private static final Logger logger = LogManager.getLogger(LoginLinkStepDefinitions.class);
	ConfigReaderUtils config;
	LoginLinkPage link;
	WebDriver driver;
	@Given("User is on the home page")
	public void user_is_on_the_home_page() throws IOException 
	{
	
	driver=Hooks.driver;
	link=new LoginLinkPage(driver);
	  config=new ConfigReaderUtils(FrameWorkConstants.Config_Path);
	  String url = config.getValue("url");
	   driver.get(url);
	  String titleOfProject=  driver.getTitle();
	  logger.info("Page title: {}", titleOfProject);
	  
	}

	@When("User clicks the Login link")
	public void user_clicks_the_login_link() 
	{
		
		link.CLickOnLoginLink();
		  logger.info("User clicked on Login link");
	}

	@Then("User should be navigated to the Login page")
	public void user_should_be_navigated_to_the_login_page() 
	{
	  String ActualURL= driver.getCurrentUrl();
	  String ExpectedURL="https://demowebshop.tricentis.com/login";
	  Assert.assertEquals(ActualURL, ExpectedURL, "URL Should be same");
	  logger.info("User navigated to Login page successfully");
	}

	@Then("Login link text should be {string}")
	public void login_link_text_should_be(String linkText) 
	{
	  String text=  link.LoginLink.getText();
	  Assert.assertEquals(text.replace(" ", ""), linkText, "Link Text should be same");
	  logger.info("Login link text is available and verified");
	}


}
