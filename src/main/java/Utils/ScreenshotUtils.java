package Utils;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils 
{
	WebDriver driver;
  public void GetScreenshot(WebDriver driver,String path)
  {
	  File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  File Destination=new File(path);
	  src.renameTo(Destination);
  }
}
