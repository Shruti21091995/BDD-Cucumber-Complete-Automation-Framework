package StepDefinitions;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import Constants.FrameWorkConstants;
import Pages.LoginLinkPage;
import Pages.LoginPage;
import Utils.ConfigReaderUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinitions 
{
	private static final Logger log = LogManager.getLogger(LoginStepDefinitions.class);
	WebDriver driver;
	LoginPage page;
	LoginLinkPage linkpage;
	ConfigReaderUtils reader;

	@Given("the user is on the login page")
	public void the_user_is_on_the_login_page() throws IOException 
	{
		log.info("Starting login test");
	    driver=Hooks.driver;
	    reader=new ConfigReaderUtils(FrameWorkConstants.Config_Path);
	    String url=reader.getValue("url");
	    driver.get(url);
	    linkpage=new LoginLinkPage(driver);
	    linkpage.CLickOnLoginLink();
	    page=new LoginPage(driver);
	    
	}

	@When("the user enters a email {string} and valid password {string}")
	public void the_user_enters_a_email_and_valid_password(String email, String password)
	{
		page.ClickLogin(email,password);
		  log.info("Login test completed successfully.");
	}
	

	@When("clicks on {string}")
	public void clicks_on(String string) 
	{
	   
	}

	@Then("the user should be logged in")
	public void the_user_should_be_logged_in() 
	{
	 String url= driver.getCurrentUrl();
	 Assert.assertTrue(url.contains("https://demowebshop.tricentis.com/"));
	 log.info("User is on login page and login is successful");
	  log.info("Login test completed successfully.");
	}

	@When("the user enters a correct email {string} but wrong password {string}")
	public void the_user_enters_a_correct_email_but_wrong_password(String email, String password)
	{
		page.ClickLogin(email,password);
	}

	@Then("an error message {string} should display")
	public void an_error_message_should_display(String ErrorMesssage) 
	{
	 String ActualError= page.ValidationSummaryError();
	 Assert.assertTrue(ActualError.contains(ErrorMesssage),
	            "Expected error message NOT found!\nActual message was:\n" + ActualError);
	 }

	@When("the user enters an unregistered email {string} and any password {string}")
	public void the_user_enters_an_unregistered_email_and_any_password(String email, String password)
	{
		page.ClickLogin(email,password);
	}

	@When("clicks {string}")
	public void clicks(String string) 
	{
	    
	}

	@Then("the error {string} or the standard login failure message should display")
	public void the_error_or_the_standard_login_failure_message_should_display(String NoAccountMessage) 
	{
	String ActualMessage= page.RegistrationNotFound();   
	Assert.assertEquals(ActualMessage, NoAccountMessage, "No Customer Account Found");
	}

	@When("the user leaves email or password blank")
	public void the_user_leaves_email_or_password_blank() 
	{
	    page.ClickLogin("", "");
	}

	@Then("validation errors should be shown \\(e.g. “Email is required”, “Password is required”)")
	public void validation_errors_should_be_shown_e_g_email_is_required_password_is_required() 
	{
		String ActualError= page.ValidationSummaryError();
		log.warn("User left email and password field blank: {}", ActualError);
	}
	@When("the user enters a email {string}  and valid password {string}")
	public void the_user_enters_a_email_and_valid_password1(String email, String passowrd)
	{
		page.ClickLogin(email,passowrd);
		log.info("Login successful for Scenario Outline");
	}



}
