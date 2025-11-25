package Utils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Constants.FrameWorkConstants;

public class WaitUtils 
{
	WebDriver driver;
 public static void ElementToBeClickable(WebDriver driver,WebElement element)
 {
	 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(FrameWorkConstants.Explicit_Wait));
	 wait.until(ExpectedConditions.elementToBeClickable(element));
 }
 
 public static void VisibilityOfElement(WebDriver driver,WebElement element)
 {
	 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(FrameWorkConstants.Explicit_Wait));
	 wait.until(ExpectedConditions.visibilityOf(element));
 }
 public static void VisibilityOfElements(WebDriver driver,List<WebElement> element)
 {
	 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(FrameWorkConstants.Explicit_Wait));
	 wait.until(ExpectedConditions.visibilityOfAllElements(element));
 }

 public static void WaitForUrlContains(WebDriver driver, String lowerCase)
 {
	 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(FrameWorkConstants.Explicit_Wait));
	 wait.until(ExpectedConditions.urlContains(lowerCase));
 }
 
}
