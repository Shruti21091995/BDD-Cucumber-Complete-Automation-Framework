package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.WaitUtils;

public class ProductConfirmationPage 
{
WebDriver driver;
@FindBy(xpath="//div[@class='title']")
public WebElement confirmationMessage;

@FindBy(xpath="//input[@class='button-2 order-completed-continue-button']")
public WebElement OrderDetailsButton;



public ProductConfirmationPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
public String GetConfirmationPage()
{
	WaitUtils.VisibilityOfElement(driver, confirmationMessage);
	String message = confirmationMessage.getText();
	return message;
}

public void ClickOnOrderDetailsPage()
{
	WaitUtils.ElementToBeClickable(driver, OrderDetailsButton);
	OrderDetailsButton.click();
}

public OrderDetailsPage ClickOnOrderDetailsPageReturn()
{
	WaitUtils.ElementToBeClickable(driver, OrderDetailsButton);
	OrderDetailsButton.click();
	return new OrderDetailsPage(driver);
}
}
//Your order has been successfully processed!
//Order number: 2136573
