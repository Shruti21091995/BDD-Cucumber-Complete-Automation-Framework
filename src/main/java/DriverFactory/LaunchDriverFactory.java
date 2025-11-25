package DriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchDriverFactory 
{
	
	static WebDriver driver=null;
   public static WebDriver CraeteDriver(String browser)
   {
	   if(browser==null)
	   {
		   browser="chrome";
	   }
	   switch(browser.toLowerCase())
	   {
	   case "chrome":
		   WebDriverManager.chromedriver().setup();
		   driver=new ChromeDriver();
		   break;
		   
	   case "edge":
		   WebDriverManager.edgedriver().setup();
		   driver=new EdgeDriver();
		   break;
		   
	   case "firefox":
		   WebDriverManager.firefoxdriver().setup();
		   driver=new FirefoxDriver();
		   break;
		   
	   case "safari":
		   WebDriverManager.safaridriver().setup();
		   driver=new SafariDriver();
		   break;
	   }
	   
	   driver.manage().window().maximize();
	   return driver;
   }
   
}
