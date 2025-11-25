package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.WaitUtils;

public class SearchPage 
{
 WebDriver driver;
 @FindBy(id="small-searchterms")
 public WebElement searchBox;
 
 @FindBy(xpath="//li[@class='ui-menu-item']/a")
 public List<WebElement> AutosuggestionList;
 @FindBy(xpath="//input[@class='button-1 search-box-button']")
 public WebElement searchButton;
 
 @FindBy(xpath="//strong[@class='result']")
 public WebElement NoItemFoundMessage;
 
 public SearchPage(WebDriver driver)
 {
	 this.driver=driver;
	 PageFactory.initElements(driver, this);
 }
 public SearchSingularFlowPage SearchFunctionality(String ProductName)
 {
	 WaitUtils.VisibilityOfElement(driver, searchBox);
	 searchBox.sendKeys(ProductName);
	 WaitUtils.VisibilityOfElement(driver, searchButton);
	 searchButton.click();
	 return new SearchSingularFlowPage(driver);
 }
 
 public void SearchProductFunctionality(String ProductName)
 {
	 WaitUtils.VisibilityOfElement(driver, searchBox);
	 searchBox.sendKeys(ProductName);
	 WaitUtils.VisibilityOfElement(driver, searchButton);
	 searchButton.click();
	 	 
 }
 public void SearchProductMethod(String ProductName)
 {
	 WaitUtils.VisibilityOfElement(driver, searchBox);
	 searchBox.sendKeys(ProductName);
	 	 
 }
 public boolean verifyAutoSuggestionContains(String expectedText) 
 {

	    WaitUtils.VisibilityOfElements(driver, AutosuggestionList);

	    for (WebElement suggestion : AutosuggestionList) {
	        String actualText = suggestion.getText().trim();

	        if (actualText.toLowerCase().contains(expectedText.toLowerCase())) {
	            return true;   // found a matching suggestion
	        }
	    }

	    return false;  // no match found
	}
 public boolean NoProductFoundMethod(String expectedText) {
	    WaitUtils.VisibilityOfElement(driver, NoItemFoundMessage);
	    return NoItemFoundMessage.getText().contains(expectedText);
	}
 public void SimpleSearchButtonClick()
 {
	 WaitUtils.VisibilityOfElement(driver, searchButton);
	 searchButton.click();
 }
}
