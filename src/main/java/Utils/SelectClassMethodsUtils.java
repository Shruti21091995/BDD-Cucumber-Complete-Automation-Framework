package Utils;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectClassMethodsUtils
{
	WebDriver driver;
  public static void SelectByVisibleText(WebDriver driver,WebElement element,String text) 
  {
	  Select select=new Select(element);
	  select.selectByVisibleText(text);
 }
  
  public static void SelectByValue(WebDriver driver,WebElement element,String Value)
  {
	  Select select=new Select(element);
	  select.selectByValue(Value);
  }
  
  public static void SelectByIndex(WebDriver driver,WebElement element,int Index)
  {
	  Select select=new Select(element);
	  select.selectByIndex(Index);
  }
  
  public static void DeselctByIndex(WebDriver driver,WebElement element,int Index)
  {
	  Select select=new Select(element);
	  select.deselectByIndex(Index);
  }
  
  public static void DeselectByValue(WebDriver driver,WebElement element,String Value)
  {
	  Select select=new Select(element);
	  select.deselectByValue(Value);
  }
  public static void DeselectByVisibleText(WebDriver driver,WebElement element,String text)
  {
	  Select select=new Select(element);
	  select.deselectByVisibleText(text);
  }
  
 public static void DeselectAll(WebDriver driver,WebElement element)
 {
	 Select select=new Select(element);
	 select.deselectAll();
 }
 public static List<WebElement> AllOptions(WebDriver river,WebElement element)
 {
	 Select select=new Select(element);
	 List<WebElement> list= select.getOptions();
	 return list;
	 
 }
 public static List<WebElement> GetSelectedOptions(WebDriver river,WebElement element)
 {
	 Select select=new Select(element);
	 List<WebElement> list=select.getAllSelectedOptions();
	 return list;
 }
 
}
