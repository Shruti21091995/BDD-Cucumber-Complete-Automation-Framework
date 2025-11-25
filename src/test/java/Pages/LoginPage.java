package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.WaitUtils;

public class LoginPage 
{
   WebDriver driver;
   @FindBy(id="Email")
   public WebElement emailTextBox;
   
   @FindBy(id="Password")
   public WebElement passwordTextBox;
   
   @FindBy(xpath="//input[@class='button-1 login-button']")
   public WebElement LoginButton;
   
   @FindBy(xpath="//div[@class='validation-summary-errors']")
   public WebElement SummaryError;
   
   @FindBy(xpath="//div[@class='validation-summary-errors']/ul/li")
   public WebElement NoRegistartionText;
   public LoginPage(WebDriver driver)
   {
	   this.driver=driver;
	   PageFactory.initElements(driver, this);
   }
   
   public void enterEmailId(String email)
   {
	   WaitUtils.VisibilityOfElement(driver, emailTextBox);
	   emailTextBox.sendKeys(email);
   }
   
   public void enterPassword(String Pass)
   {
	   WaitUtils.VisibilityOfElement(driver, passwordTextBox);
	   passwordTextBox.sendKeys(Pass);
   }
   public void LoginButtonClick()
   {
	   WaitUtils.ElementToBeClickable(driver, LoginButton);
	   LoginButton.click();
   }
   public void ClickLogin(String email,String Pass)
   {
	   enterEmailId(email);
	   enterPassword(Pass);
	   LoginButtonClick();
   }
   public HomePage ClickLoginReturnTypeMethod(String email,String Pass)
   {
	   enterEmailId(email);
	   enterPassword(Pass);
	   LoginButtonClick();
	   return new HomePage(driver);
   }
   public String ValidationSummaryError()
   {
	   WaitUtils.VisibilityOfElement(driver, SummaryError);
	   String errorMessage=SummaryError.getText();
	   return errorMessage;
   }
   public String RegistrationNotFound()
   {
	   WaitUtils.VisibilityOfElement(driver, NoRegistartionText);
	   String NoAccount=NoRegistartionText.getText();
	   return NoAccount;
   }
   
   
}
