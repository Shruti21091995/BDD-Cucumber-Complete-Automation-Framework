package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.JavaScriptExecutorUtils;
import Utils.WaitUtils;

public class RegisterPage 
{
WebDriver driver;

@FindBy(xpath="//div[@class='inputs']/span[@class='field-validation-error']")
public List<WebElement> errorList;

@FindBy(xpath="//a[@class='ico-register']")
public WebElement RegisterLink;

@FindBy(xpath="//input[@name='Gender']")
public List<WebElement> Genderlist;

@FindBy(id="FirstName")
public WebElement firstname;

@FindBy(id="LastName")
public WebElement lastname;
@FindBy(id="Email")
public WebElement email;
@FindBy(id="Password")
public WebElement password;
@FindBy(id="ConfirmPassword")
public WebElement confirmpassword;
@FindBy(id="register-button")
public WebElement RegisterButton;

@FindBy(xpath="//div[@class='result']")
public WebElement RegistartionSuccessMessage;

@FindBy(xpath="//input[@class='button-1 register-continue-button']")
public WebElement ContinueButton;

@FindBy(xpath="//div[@class='validation-summary-errors']")
public WebElement EmailAlreadyRegistred;

@FindBy(xpath="//span[@for='Email']")
public WebElement FieldValidationError;

@FindBy(xpath="//span[@for='ConfirmPassword']")
public WebElement PasswordValidationError;

public RegisterPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
public void ClickOnRegisterLink()
{
	WaitUtils.VisibilityOfElement(driver, RegisterLink);
	RegisterLink.click();
}

public void SelectGenderMethod(String UserDefinedGender)
{
	WaitUtils.VisibilityOfElements(driver, Genderlist);
	for(WebElement element:Genderlist)
	{
		// Radio buttons use 'value' attribute, not text
		String genderValue = element.getAttribute("value");
		if(genderValue.equalsIgnoreCase(UserDefinedGender))
		{
			// Use JavaScript click for radio buttons to ensure they get selected
			JavaScriptExecutorUtils.ClickOnElementUsingJavaScriptExecutor(driver, element);
			break;
		}
		System.out.println("✅ Gender clicked successfully");
	}
}
public void RegistrationDetails(String firstame,String Lastname,String Email,String pass,String confirmPass,String UserDefinedGender)
{
	SelectGenderMethod(UserDefinedGender);
	
	WaitUtils.VisibilityOfElement(driver, firstname);
	firstname.sendKeys(firstame);
	
	WaitUtils.VisibilityOfElement(driver, lastname);
	lastname.sendKeys(Lastname);
	
	WaitUtils.VisibilityOfElement(driver, email);
	email.sendKeys(Email);
	
	WaitUtils.VisibilityOfElement(driver, password);
	password.sendKeys(pass);
	
	WaitUtils.VisibilityOfElement(driver, confirmpassword);
	confirmpassword.sendKeys(confirmPass);
	
	WaitUtils.VisibilityOfElement(driver, RegisterButton);
	RegisterButton.click();
	
}
public void enterFirstName(String firstame)
{
	WaitUtils.VisibilityOfElement(driver, firstname);
	firstname.sendKeys(firstame);
}
public void enterLastName(String Lastname)
{
	WaitUtils.VisibilityOfElement(driver, lastname);
	lastname.sendKeys(Lastname);
}
public void enterEmail(String Email)
{
	WaitUtils.VisibilityOfElement(driver, email);
	email.sendKeys(Email);
}
public void enterPassword(String pass)
{
	WaitUtils.VisibilityOfElement(driver, password);
	password.sendKeys(pass);
}
public void enterConfirmPassword(String confirmPass)
{
	WaitUtils.VisibilityOfElement(driver, confirmpassword);
	confirmpassword.sendKeys(confirmPass);
}
public void Register()
{
	WaitUtils.VisibilityOfElement(driver, RegisterButton);
	RegisterButton.click();
}
public String RegistrationSuccessMethod()
{
	WaitUtils.VisibilityOfElement(driver, RegistartionSuccessMessage);
	String result=RegistartionSuccessMessage.getText().trim();
	return result;
}
public HomePage ClickOnContinueButton()
{
	WaitUtils.VisibilityOfElement(driver, ContinueButton);
	ContinueButton.click();
	return new HomePage(driver);
	
}

public String ValidateRegistrationOfSameMail()
{
	WaitUtils.VisibilityOfElement(driver, EmailAlreadyRegistred);
	String ActualMessage=EmailAlreadyRegistred.getText();
	return ActualMessage;
}
public String ValidationTextEmailFiled()
{
	WaitUtils.VisibilityOfElement(driver, FieldValidationError);
	String ActualMessage=FieldValidationError.getText();
	return ActualMessage;
}
public String PasswordValiationMethod()
{
	WaitUtils.VisibilityOfElement(driver, PasswordValidationError);
	String ActualMessage=PasswordValidationError.getText();
	return ActualMessage;
}
public List<String> getAllErrors() {

	WaitUtils.VisibilityOfElements(driver, errorList);
    List<String> errors = new ArrayList<>();
    for(WebElement element:errorList)
    {
    String errorMessage=element.getText();
    errors.add(errorMessage);
    }
    return errors;
}

}
