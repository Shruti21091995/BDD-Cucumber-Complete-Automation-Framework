package Utils;

import org.openqa.selenium.WebDriver;

public class NavigationUtils 
{
   WebDriver driver;
	public static void Navigation_To(WebDriver driver,String URL)
	{
		driver.navigate().to(URL);
	}
	
	public static void Navigation_back(WebDriver driver)
	{
		driver.navigate().back();
	}
	
	public static void Navigate_forward(WebDriver driver) 
	{
		driver.navigate().forward();
	}
	public static void Navigate_Refresh(WebDriver driver)
	{
		driver.navigate().refresh();
	}
}

