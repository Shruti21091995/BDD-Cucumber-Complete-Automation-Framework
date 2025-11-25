package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.SelectClassMethodsUtils;
import Utils.WaitUtils;

public class CheckOutPage 
{
WebDriver driver;
@FindBy(xpath="//input[@name='removefromcart']")
public List<WebElement> removeCartCheckBox;

// Generic quantity field locator
@FindBy(xpath="//input[contains(@name,'itemquantity')]")
public WebElement QtyTextField;

@FindBy(xpath="//input[@name='updatecart']")
public WebElement UpdateCartButton;

@FindBy(xpath="//input[@name='continueshopping']")
public WebElement ContinueShoppingButton;

@FindBy(xpath="//input[@name='discountcouponcode']")
public WebElement enterCouponTextBox;

@FindBy(xpath="//input[@name='applydiscountcouponcode']")
public WebElement ApplyCouponButton;

@FindBy(xpath="//input[@name='giftcardcouponcode']")
public WebElement enterGiftCardTextBox;

@FindBy(xpath="//input[@name='applygiftcardcouponcode']")
public WebElement AddGiftCardButton;

@FindBy(id="CountryId")
public WebElement CountryDropDown;

@FindBy(id="ZipPostalCode")
public WebElement postalCodeTextBox;

@FindBy(xpath="//input[@name='estimateshipping']")
public WebElement estimateShippingButton;

@FindBy(id="termsofservice")
public WebElement termOfServiceCheckBox;

@FindBy(id="checkout")
public WebElement CheckOutButton;

public CheckOutPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
public void ClickOnProductsCheckBoxs()
{
	WaitUtils.VisibilityOfElements(driver, removeCartCheckBox);
	for(WebElement element:removeCartCheckBox)
	{
		element.click();
		WaitUtils.VisibilityOfElement(driver, element);
		UpdateCartButton.click();
	}
}
public ContinueShoppingPage ContinueShoppingButtonClick()
{
	WaitUtils.VisibilityOfElement(driver, ContinueShoppingButton);
	ContinueShoppingButton.click();
	return new ContinueShoppingPage(driver);
}
public void AddCouponTextBoxMethod(String Coupon)
{
	WaitUtils.VisibilityOfElement(driver, enterCouponTextBox);
	enterCouponTextBox.sendKeys(Coupon);
	WaitUtils.VisibilityOfElement(driver, ApplyCouponButton);
	ApplyCouponButton.click();
}
public void AddGiftCardmethod(String giftcard)
{
	WaitUtils.VisibilityOfElement(driver, enterGiftCardTextBox);
	enterGiftCardTextBox.sendKeys(giftcard);
	WaitUtils.VisibilityOfElement(driver, AddGiftCardButton);
	AddGiftCardButton.click();
}
public void selectCountryDropdownMethod(String country)
{
	WaitUtils.VisibilityOfElement(driver, CountryDropDown);
	SelectClassMethodsUtils.SelectByValue(driver, CountryDropDown, country);
	CountryDropDown.click();
}

public void enterPostalCode(String postalCode)
{
	WaitUtils.VisibilityOfElement(driver, postalCodeTextBox);
	postalCodeTextBox.sendKeys(postalCode);
	WaitUtils.VisibilityOfElement(driver, estimateShippingButton);
	estimateShippingButton.click();
}
public void selectTermsAndService()
{
	WaitUtils.VisibilityOfElement(driver, termOfServiceCheckBox);
	termOfServiceCheckBox.click();
}
public BillingPage ClickOnCheckOutButton()
{
	WaitUtils.VisibilityOfElement(driver, CheckOutButton);
	CheckOutButton.click();
	return new BillingPage(driver);
}
public void UpdateCartMethod(String UserDefinedQuantity)
{
	WaitUtils.VisibilityOfElement(driver, QtyTextField);
	QtyTextField.clear();
	QtyTextField.sendKeys(UserDefinedQuantity);
	WaitUtils.VisibilityOfElement(driver, UpdateCartButton);
	UpdateCartButton.click();
	
}


}
