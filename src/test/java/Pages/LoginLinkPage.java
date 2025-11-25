package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.WaitUtils;
public class LoginLinkPage 
{
 WebDriver driver;
 
 @FindBy(xpath="//a[@class='ico-login']")
 public WebElement LoginLink;
 
 public LoginLinkPage(WebDriver driver)
 {
	 this.driver=driver;
	 PageFactory.initElements(driver, this);
 }
 
 public void CLickOnLoginLink()
 {
	WaitUtils.VisibilityOfElement(driver, LoginLink);
	LoginLink.click();
	
 }
 public LoginPage CLickOnLoginLinkReturn()
 {
	WaitUtils.VisibilityOfElement(driver, LoginLink);
	LoginLink.click();
	return new LoginPage(driver);
 }
}
