package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.ActionClassMethodsUtils;
import Utils.JavaScriptExecutorUtils;
import Utils.WaitUtils;

public class HomePage 
{
 WebDriver driver;
 @FindBy(id="newsletter-email")
 public WebElement newLetterEmail;
 
 @FindBy(id="newsletter-subscribe-button")
 public WebElement subscribeButton;
 
 @FindBy(id="newsletter-result-block")
 public WebElement confirmationText;
 
 @FindBy(xpath="//div[@class='product-item']")
 public List<WebElement> featureProductList;
 
 @FindBy(xpath="//div[@class='header-menu']/ul[@class='top-menu']/li[2]/a")
 public WebElement HoverLinkComputers;
 
 @FindBy(xpath="//div[@class='header-menu']/ul[@class='top-menu']/li[2]/ul[@class='sublist firstLevel active']/li[2]")
 public WebElement NoteBookLink;
 
 @FindBy(xpath="//ul[@class='top-menu']/li/a")
 public List<WebElement> CategoryList;
 
 public HomePage(WebDriver driver)
 {
	 this.driver=driver;
	 PageFactory.initElements(driver, this);
 }
 
public void enterNewsLetterEmail(String email)
{
	WaitUtils.VisibilityOfElement(driver, newLetterEmail);
	newLetterEmail.sendKeys(email);
}

public void ClickSubscribe()
{
	WaitUtils.VisibilityOfElement(driver, subscribeButton);
	subscribeButton.click();
}

public void SubscribeMethod(String email)
{
	enterNewsLetterEmail(email);
	ClickSubscribe();
}
public String GetConfirmationSubscriptions()
{
	WaitUtils.VisibilityOfElement(driver, confirmationText);
	String result=confirmationText.getText();
	return result;
}
public void ClickOnOptionBasedOnParamter(String ProductName)
{
	WaitUtils.VisibilityOfElements(driver, featureProductList);
	for(WebElement product:featureProductList)
	{
	String FeatureProduct=product.getText().trim();
	// Use contains instead of exact match
	if(FeatureProduct.toLowerCase().contains(ProductName.toLowerCase()))
	{
		// Find any link inside the product div
		WebElement productLink = product.findElement(By.tagName("a"));
		productLink.click();
		break;
	}
	}
}
public ProductPage ClickOnOptionBasedOnParamterReturn(String ProductName)
{
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	
	WaitUtils.VisibilityOfElements(driver, featureProductList);
	System.out.println("Total products found: " + featureProductList.size());
	
	boolean productClicked = false;
	for(WebElement product:featureProductList)
	{
		String FeatureProduct=product.getText().trim();
		System.out.println("Found product: " + FeatureProduct);
		// Use contains instead of exact match
		if(FeatureProduct.toLowerCase().contains(ProductName.toLowerCase()))
		{
			System.out.println("Clicking on product: " + FeatureProduct);
			// Find any link inside the product div
			WebElement productLink = product.findElement(By.tagName("a"));
			System.out.println("Product link found: " + productLink.getAttribute("href"));
			productLink.click();
			productClicked = true;
			
			// Wait for navigation
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			break;
		}
	}
	
	if(!productClicked)
	{
		System.out.println("Product '" + ProductName + "' not found! Available products listed above.");
	}
	
	return new ProductPage(driver);
}
public List<String> getProductList()
{
	WaitUtils.VisibilityOfElements(driver, featureProductList);
	 List<String> productNamesList = new ArrayList<>();
	for(WebElement product:featureProductList)
	{
	String productname=product.getText().trim();
	 productNamesList.add(productname);
	}
	return productNamesList;
}

public List<String> GetCatgoryList() throws InterruptedException
{
	 Thread.sleep(2000);
	WaitUtils.VisibilityOfElements(driver, CategoryList);
	 List<String> CategoryNamesList = new ArrayList<>();
	for(WebElement category:CategoryList)
	{
	String categorytname=category.getText().trim();
	CategoryNamesList.add(categorytname);
	}
	return CategoryNamesList;
}
public void ClickOnCategoryOptionBasedOnParamter(String CategoryName)
{
	WaitUtils.VisibilityOfElements(driver, CategoryList);
	for(WebElement category:CategoryList)
	{
	String categoryname=category.getText().trim();
	if(categoryname.equalsIgnoreCase(CategoryName))
	{
		JavaScriptExecutorUtils.ClickOnElementUsingJavaScriptExecutor(driver, category);
		WaitUtils.WaitForUrlContains(driver, CategoryName.toLowerCase());
		break;
	}
	}
	
}
public void Hover()
{
	WaitUtils.VisibilityOfElement(driver, HoverLinkComputers);
	ActionClassMethodsUtils.hoverOnElement(driver, HoverLinkComputers);
	WaitUtils.VisibilityOfElement(driver, NoteBookLink);
	NoteBookLink.click();
}
}
