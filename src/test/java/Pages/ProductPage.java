package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.WaitUtils;

public class ProductPage 
{
WebDriver driver;

    @FindBy(xpath="//span[@class='value']")
	public WebElement CheckItemAvailability;
    @FindBy(xpath = "//table[@class='cart']//th")
    public List<WebElement> cartTableHeaders;
    // Generic locator that works for any product - using class name
    @FindBy(xpath="//input[@class='qty-input']")
    public WebElement quantityBox;
    ////input[@class='button-2 product-box-add-to-cart-button']
    ///
    ///
    // Generic Add to cart button locator
    @FindBy(xpath="//input[@value='Add to cart' or @value='Add to wishlist']")
    public WebElement AddToCartButton;

    @FindBy(xpath="//li[@id='topcartlink']/a[@class='ico-cart']")
    public WebElement shoppingCartLink;
    
 public ProductPage(WebDriver driver)
 {
	 this.driver=driver;
	 PageFactory.initElements(driver, this);
 }
 
 public void ClickOnAddToCartButton(String quantity)
 {
	WaitUtils.VisibilityOfElement(driver, CheckItemAvailability);
	String ActualValue= CheckItemAvailability.getText();
	if(ActualValue.equalsIgnoreCase("In stock"))
	{
		WaitUtils.VisibilityOfElement(driver, quantityBox);
		quantityBox.sendKeys(quantity);
		
		WaitUtils.ElementToBeClickable(driver, AddToCartButton);
		AddToCartButton.click();
		
	}
	
 }
 public CheckOutPage ClickOnAddToCartButtonReturn(String quantity)
 {
	WaitUtils.VisibilityOfElement(driver, CheckItemAvailability);
	String ActualValue= CheckItemAvailability.getText();
	if(ActualValue.equalsIgnoreCase("In stock"))
	{
		WaitUtils.VisibilityOfElement(driver, quantityBox);
		quantityBox.sendKeys(quantity);
		
		WaitUtils.ElementToBeClickable(driver, AddToCartButton);
		AddToCartButton.click();
		
	}
	return new CheckOutPage(driver);
	
 }
   public void ClickOnShoppingCartLink()
    {
	 WaitUtils.VisibilityOfElement(driver, shoppingCartLink);
	 shoppingCartLink.click();
    }
   
   public List<String> getCartTableHeaders() {
	    List<String> headers = new ArrayList<>();
	    for (WebElement header : cartTableHeaders) {
	        headers.add(header.getText().trim());
	    }
	    return headers;
	}
 
}
