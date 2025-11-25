package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.SelectClassMethodsUtils;
import Utils.WaitUtils;

public class BillingPage 
{
 WebDriver driver;
 @FindBy(xpath="billing-address-select")
 public WebElement SelectBillingAddress;
 
 @FindBy(id="shipping-address-select")
 public WebElement SelectShippingAddress;
 
 @FindBy(xpath="//input[@onClick='Billing.save()']")
 public WebElement BillingAddressContinueButton;
  @FindBy(xpath="//input[@onClick='Shipping.save()']")
  public WebElement ShippingAddressContinueButton;
  
  @FindBy(xpath="//input[@onClick='ShippingMethod.save()']")
  public WebElement ShippingMethodContinueButton;
  
  @FindBy(xpath="//input[@onClick='PaymentMethod.save()']")
  public WebElement PaymentMethodContinueButton;
  
  @FindBy(xpath="//input[@onClick='PaymentInfo.save()']")
  public WebElement PaymentInfocontinueButton;
  
  @FindBy(xpath="//input[@onClick='ConfirmOrder.save()']")
  public WebElement ConfirmButton;
  
  @FindBy(xpath="//div[@class='method-name']//input[@name='shippingoption']")
  public List<WebElement> ShippingOptionsList;
  
  @FindBy(xpath="//input[@name='paymentmethod']")
  public List<WebElement> paymentMethods;
  
  @FindBy(id="BillingNewAddress_FirstName")
  public WebElement firstName;
  
  @FindBy(id="BillingNewAddress_LastName")
  public WebElement lastname;
  @FindBy(id="BillingNewAddress_Email")
  public WebElement email;
  
  
  @FindBy(id="BillingNewAddress_CountryId")
  public WebElement CountryDropdown;
  
  @FindBy(id="BillingNewAddress_City")
  public WebElement city;
  @FindBy(id="BillingNewAddress_Address1")
  public WebElement address;
  @FindBy(id="BillingNewAddress_ZipPostalCode")
  public WebElement postalCode;
  
  @FindBy(id="BillingNewAddress_PhoneNumber")
  public WebElement mobileNumber;
  
  @FindBy(id="ShippingNewAddress_FirstName")
  public WebElement ShippingAddress_FirstName;
  
  @FindBy(id="ShippingNewAddress_LastName")
  public WebElement ShippingAddress_LastName;
  
  @FindBy(id="ShippingNewAddress_Email")
  public WebElement ShippingAddress_email;
  
  @FindBy(id="ShippingNewAddress_Company")
  public WebElement ShippingAddress_company;
  
  @FindBy(id="ShippingNewAddress_CountryId")
  public WebElement ShippingAddress_Country;
  
  @FindBy(id="ShippingNewAddress_City")
  public WebElement ShippingAddress_City;
  
  @FindBy(id="ShippingNewAddress_Address1")
  public WebElement ShippingAddress_address;
  
  @FindBy(id="ShippingNewAddress_ZipPostalCode")
  public WebElement ShippingAddress_PostalCode;
  
  @FindBy(id="ShippingNewAddress_PhoneNumber")
  public WebElement ShippingAddress_PhoneNumber;
 public BillingPage(WebDriver driver)
 {
	 this.driver=driver;
	 PageFactory.initElements(driver, this);
 }
 
 public void FillBillingAddress(String NewValue,String Value,String firstname,String Lastname,String Email,String City,String Address,String PostalCode,String phoneNumber)
 {
	 WaitUtils.VisibilityOfElement(driver, SelectBillingAddress);
	 SelectClassMethodsUtils.SelectByVisibleText(driver, SelectBillingAddress, Value);
	 SelectBillingAddress.click();
	 
	 WaitUtils.VisibilityOfElement(driver, firstName);
	 firstName.sendKeys(firstname);
	 
	 WaitUtils.VisibilityOfElement(driver, lastname);
	 lastname.sendKeys(Lastname);
	 
	 WaitUtils.VisibilityOfElement(driver, email);
	 email.sendKeys(Email);
	 
	 WaitUtils.VisibilityOfElement(driver, CountryDropdown);
	 SelectClassMethodsUtils.SelectByVisibleText(driver, CountryDropdown, NewValue);
	 CountryDropdown.click();
	 
	 WaitUtils.VisibilityOfElement(driver, city);
	 city.sendKeys(City);
	 
	 WaitUtils.VisibilityOfElement(driver, address);	 
	 address.sendKeys(Address);
	 
	 WaitUtils.VisibilityOfElement(driver, postalCode);
	 postalCode.sendKeys(PostalCode);
	 
	 WaitUtils.VisibilityOfElement(driver, mobileNumber);
	 mobileNumber.sendKeys(phoneNumber);
	 
	 WaitUtils.VisibilityOfElement(driver, BillingAddressContinueButton);
	 BillingAddressContinueButton.click();
 }

 public void FillShippingAddress(String NewValue,String Value,String firstname,String Lastname,String Email,String City,String Address,String PostalCode,String phoneNumber)
 {
	 WaitUtils.VisibilityOfElement(driver, SelectShippingAddress);
	 SelectClassMethodsUtils.SelectByVisibleText(driver, SelectShippingAddress, Value);
	 SelectShippingAddress.click();
	 
	 WaitUtils.VisibilityOfElement(driver, ShippingAddress_FirstName);
	 ShippingAddress_FirstName.sendKeys(firstname);
	 
	 WaitUtils.VisibilityOfElement(driver, ShippingAddress_LastName);
	 ShippingAddress_LastName.sendKeys(Lastname);
	 
	 WaitUtils.VisibilityOfElement(driver, ShippingAddress_email);
	 ShippingAddress_email.sendKeys(Email);
	 
	 WaitUtils.VisibilityOfElement(driver, ShippingAddress_Country);
	 SelectClassMethodsUtils.SelectByVisibleText(driver, ShippingAddress_Country, NewValue);
	 ShippingAddress_Country.click();
	 
	 WaitUtils.VisibilityOfElement(driver, ShippingAddress_City);
	 ShippingAddress_City.sendKeys(City);
	 
	 WaitUtils.VisibilityOfElement(driver, ShippingAddress_address);
	 ShippingAddress_address.sendKeys(Address);
	 
	 WaitUtils.VisibilityOfElement(driver, ShippingAddress_PostalCode);
	 ShippingAddress_PostalCode.sendKeys(PostalCode);
	 
	 WaitUtils.VisibilityOfElement(driver, ShippingAddress_PhoneNumber);
	 ShippingAddress_PhoneNumber.sendKeys(phoneNumber);
	 
	 WaitUtils.VisibilityOfElement(driver, ShippingAddressContinueButton);
	 ShippingAddressContinueButton.click();
 }
 
 public void ShippingMethodSelect(String ShippingMethodUserProvided)
 {
	 WaitUtils.VisibilityOfElements(driver, ShippingOptionsList);
	 for(WebElement element:ShippingOptionsList)
	 {
		 String ShippingAddress=element.getText().trim();
		 if(ShippingAddress.equalsIgnoreCase(ShippingMethodUserProvided))
		 {
			 element.click();
			 break;
		 }
	 }
 }
 public void PaymentMethod(String UserProvidedPaymentMethod)
 {
	 WaitUtils.VisibilityOfElements(driver, paymentMethods);
	 for(WebElement element:paymentMethods)
	 {
		 String PaymentMethod=element.getText().trim();
		 if(PaymentMethod.equalsIgnoreCase(UserProvidedPaymentMethod))
		 {
			 element.click();
			 break;
		 }
	 }
 }
 public void PaymentInfo()
 {
	 WaitUtils.ElementToBeClickable(driver, PaymentInfocontinueButton);
	 PaymentInfocontinueButton.click();
 }
 public ProductConfirmationPage ConfirmationMethodReturn()
 {
	 WaitUtils.VisibilityOfElement(driver, ConfirmButton);
	 ConfirmButton.click();
	 return new ProductConfirmationPage(driver);
 }
 public void ConfirmationMethod()
 {
	 WaitUtils.ElementToBeClickable(driver, ConfirmButton);
	 ConfirmButton.click();
 }
}
