package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.WaitUtils;

public class SearchSingularFlowPage 
{
  WebDriver driver;
  @FindBy(xpath="//input[@class='button-2 product-box-add-to-cart-button']")
  public WebElement addToCartButton;
  @FindBy(id="topcartlink")
  public WebElement shoppingcartLink;
  
  
  public SearchSingularFlowPage(WebDriver driver)
  {
	  this.driver=driver;
	  PageFactory.initElements(driver, this);
  }
  public void AddProductToCart()
  {
	  WaitUtils.VisibilityOfElement(driver, addToCartButton);
	  addToCartButton.click();
  }
  public CheckOutPage ClickOnShoopinCartLink()
  {
	  WaitUtils.VisibilityOfElement(driver, shoppingcartLink);
	  shoppingcartLink.click();
	  return new CheckOutPage(driver);
  }
  
  
}
