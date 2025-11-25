package Utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptExecutorUtils 
{
	WebDriver driver;
	
public static void ClickOnElementUsingJavaScriptExecutor(WebDriver driver,WebElement element) 
{
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();", element);
}
public static void EnterTextInTextBox(WebDriver driver,WebElement element)
{
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].value='Selenium';", element);
}

public static void ScrollDuwnByPixel(WebDriver driver)
{
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("Window.ScrollBy(0,500)");
}
public static void ScrollUpByPixel(WebDriver driver)
{
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("Window.ScrollBy(500,0)");
}
  public static void ScrollDownToElement(WebDriver driver,WebElement element)
{
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].ScrollIntoView(true)", element);
}
  public static String GetPageTitleMrthod(WebDriver driver)
  {
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  String TitleOfPage= (String)js.executeAsyncScript("reurn document.title;");
	 return TitleOfPage;
  }

}
