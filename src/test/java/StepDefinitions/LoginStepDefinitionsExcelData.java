package StepDefinitions;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import Constants.FrameWorkConstants;
import Pages.LoginLinkPage;
import Pages.LoginPage;
import Runner.ExcelLoginRunner;
import Utils.ConfigReaderUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class LoginStepDefinitionsExcelData 
{
	private static final Logger logger = LogManager.getLogger(LoginStepDefinitionsExcelData.class);
	int currentIndex = 0; // Track which row is being executed
	LoginPage page;
	WebDriver driver;
	LoginLinkPage linkpage;
	ConfigReaderUtils reader;
	@Given("user launches the browser")
	public void user_launches_the_browser() throws IOException
	{
		driver = Hooks.driver;
		
		if (driver == null) {
			logger.error("Driver is null. Hooks @Before may not have run");
			throw new RuntimeException("WebDriver is not initialized. Check Hooks configuration.");
		}
		
		reader = new ConfigReaderUtils(FrameWorkConstants.Config_Path);
		String url = reader.getValue("url");
		driver.get(url);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		linkpage = new LoginLinkPage(driver);
		linkpage.CLickOnLoginLink();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		page = new LoginPage(driver);
	}
	@When("user enters username and password from Excel")
	public void user_enters_username_and_password_from_excel()
	{
		 String username = (String) ExcelLoginRunner.excelData[currentIndex][0];
	      String password = (String) ExcelLoginRunner.excelData[currentIndex][1];

	        currentIndex++;

	        // Now use POM to enter login details
	       page.ClickLogin(username, password);
	    }
	

	@Then("user should be logged in successfully")
	public void user_should_be_logged_in_successfully() 
	{
	    String url=driver.getCurrentUrl();
	    Assert.assertTrue(url.contains("https://demowebshop.tricentis.com/"));
	    logger.info("User login completed successfully");
	}
}
