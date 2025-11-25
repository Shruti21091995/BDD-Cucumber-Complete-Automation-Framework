package StepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Constants.FrameWorkConstants;
import Pages.RegisterPage;
import Utils.ConfigReaderUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterStepDefinitions 
{
 private static final Logger logger = LogManager.getLogger(RegisterStepDefinitions.class);
 WebDriver driver;
 ConfigReaderUtils config;
 RegisterPage register;
 
 /**
  * Generates a unique email by adding current time to it
  * 
  * HOW IT WORKS:
  * Input:  smita.patil@gmail.com
  * Output: smita.patil_1732531200@gmail.com
  * 
  * Every time you run the test, the number changes, so email is always unique!
  */
 private String generateDynamicEmail(String originalEmail) {
     
     // Step 1: Get current time in milliseconds (this number is always different)
     long currentTime = System.currentTimeMillis();
     
     // Step 2: Split email into two parts: before @ and after @
     // Example: "smita.patil@gmail.com" becomes ["smita.patil", "gmail.com"]
     String beforeAt = originalEmail.split("@")[0];  // smita.patil
     String afterAt = originalEmail.split("@")[1];   // gmail.com
     
     // Step 3: Create new email by adding time between name and @
     // Result: smita.patil_1732531200@gmail.com
     String uniqueEmail = beforeAt + "_" + currentTime + "@" + afterAt;
     
     // Step 4: Return the unique email
     return uniqueEmail;
 }
 @Given("the user is on the registration page")
 public void the_user_is_on_the_registration_page() throws IOException 
 {
	driver=Hooks.driver;
    config=new ConfigReaderUtils(FrameWorkConstants.Config_Path);
    String BrowserUrl=config.getValue("url");
    driver.get(BrowserUrl);
    register=new RegisterPage(driver);
    register.ClickOnRegisterLink();
   String RegisterationPageUrl= driver.getCurrentUrl();
   Assert.assertTrue(RegisterationPageUrl.contains("/register"), "Registration page did not get loaded");
   logger.info("Registration page loaded successfully");
 }

 @When("the user provides valid details:")
 public void the_user_provides_valid_details(io.cucumber.datatable.DataTable dataTable) 
 {
	 List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

	    String firstName = data.get(0).get("FirstName");
	    String lastName = data.get(0).get("LastName");
	    String email = data.get(0).get("Email");
	    String password = data.get(0).get("Password");
	    String confirmPassword = data.get(0).get("ConfirmPassword");
	    
	    // Generate dynamic email to avoid duplicate registration
	    String dynamicEmail = generateDynamicEmail(email);
	    logger.info("Using dynamic email for registration: {}", dynamicEmail);
	    
	    // Example: fill your registration page fields
	  register.RegistrationDetails(firstName, lastName, dynamicEmail, password, confirmPassword,"Female");
	  
	  
 }

 @When("clicks on the {string} button")
 public void clicks_on_the_button(String string) 
 {
    
 }

 @Then("registration should be successful")
 public void registration_should_be_successful()
 {
   String ActualText= register.RegistrationSuccessMethod();
   Assert.assertTrue(ActualText.equalsIgnoreCase("Your registration completed"), "Registartion is not successful");
 }

 @When("the user enters an email that is already registered as below:")
 public void the_user_enters_an_email_that_is_already_registered_as_below(io.cucumber.datatable.DataTable dataTable)
 {
	 List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
	   String firstName = data.get(0).get("FirstName");
	    String lastName = data.get(0).get("LastName");
	    String email = data.get(0).get("Email");
	    String password = data.get(0).get("Password");
	    String confirmPassword = data.get(0).get("ConfirmPassword");
	    // Example: fill your registration page fields
	  register.RegistrationDetails(firstName, lastName, email, password, confirmPassword,"Female");
 }
 @When("gives other valid details")
 public void gives_other_valid_details() 
 {
     //already entered the credentials
 }

 @Then("the error message {string} should be displayed")
 public void the_error_message_should_be_displayed(String expaectedMessage)
 {
    String ActualMessage= register.ValidateRegistrationOfSameMail();
    Assert.assertTrue(ActualMessage.contains(expaectedMessage), "Mail is already created message not displayed");
 }

 @When("the user enters {string} in the email field")
 public void the_user_enters_in_the_email_field(String email) 
 {
  register.enterEmail(email);
 }

 @When("fills other valid fields")
 public void fills_other_valid_fields()
 {
  register.SelectGenderMethod("female");
  register.enterFirstName("shruti");
  register.enterLastName("patil");
  register.enterPassword("shruti@123");
  register.enterConfirmPassword("shruti@123");
  register.Register();
  
 }

 @Then("validation message {string} \\(or similar) should appear")
 public void validation_message_or_similar_should_appear(String ExpectedMessage) 
 {
	 String ActualMessage= register.ValidationTextEmailFiled();
	  Assert.assertTrue(ActualMessage.contains(ExpectedMessage), "Incorrect email field message not displayed");
 }

 @When("the user enters a password {string} and confirmation {string}")
 public void the_user_enters_a_password_and_confirmation(String pass, String confirmpass)
 {
	 register.enterPassword(pass);
	  register.enterConfirmPassword(confirmpass);
 }

 @When("other required details correctly")
 public void other_required_details_correctly() 
 {
	 register.SelectGenderMethod("female");
	  register.enterFirstName("hiten");
	  register.enterLastName("sharma");
	  register.enterEmail("hiten.sharma@test.com");
	  register.Register();
 }

 @Then("an error {string} should display")
 public void an_error_should_display(String ErrorMessage) 
 {
	 String ActualMessage= register.PasswordValiationMethod();
	 logger.info("Expected error: {}", ErrorMessage);
	 logger.info("Actual error found: {}", ActualMessage);
	  Assert.assertTrue(ActualMessage.contains(ErrorMessage), "password validation error message not displayed. Expected: '" + ErrorMessage + "' but found: '" + ActualMessage + "'");
 }

 @When("the user leaves FirstName or LastName or Email or Password empty")
 public void the_user_leaves_first_name_or_last_name_or_email_or_password_empty() 
 {
	  register.Register();
 }

 @Then("appropriate validation messages should be shown for each required field")
 public void appropriate_validation_messages_should_be_shown_for_each_required_field() 
 {
	  List<String> errors = register.getAllErrors();

	    Assert.assertTrue(errors.contains("First name is required."), "Missing: First name r");
	    Assert.assertTrue(errors.contains("Password is required."), "Missing: Confirm password error");
 }

}
