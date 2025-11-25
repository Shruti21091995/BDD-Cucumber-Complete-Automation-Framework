package StepDefinitions;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import Constants.FrameWorkConstants;
import DriverFactory.LaunchDriverFactory;
import Utils.ConfigReaderUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Attachment;

public class Hooks 
{
 private static final Logger logger = LogManager.getLogger(Hooks.class);
 public static WebDriver driver;
 ConfigReaderUtils config;
 
 @Before
 public void SetUp() throws IOException
 {
	 String browserName = System.getProperty("BrowserName");
	 if (browserName == null || browserName.isEmpty())
	 {
		 config = new ConfigReaderUtils(FrameWorkConstants.Config_Path);
		 String browser = config.getValue("browser");
		 logger.info("Initializing {} browser from config file", browser);
		 driver = LaunchDriverFactory.CraeteDriver(browser);
	 }
	 else
	 {
		 logger.info("Initializing {} browser from system property", browserName);
		 driver = LaunchDriverFactory.CraeteDriver(browserName);
	 }
	 logger.info("Browser initialized successfully");
 }
 
 @After
 public void TearDown(Scenario scenario)
 {
	 if(scenario.isFailed())
	 {
		 logger.error("Scenario failed: {}", scenario.getName());
		 byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		 scenario.attach(screenshot, "image/png", scenario.getName());
		 logger.info("Screenshot captured for failed scenario");
	 }
	 else
	 {
		 logger.info("Scenario passed: {}", scenario.getName());
	 }
	 
	 if(driver != null)
	 {
		 driver.quit();
		 logger.info("Browser closed successfully");
	 }
 }
}
