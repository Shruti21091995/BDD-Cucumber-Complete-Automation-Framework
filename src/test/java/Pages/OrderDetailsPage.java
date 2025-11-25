package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.WaitUtils;

public class OrderDetailsPage 
{
WebDriver driver;
@FindBy(xpath="//h1[contains(text(),'Order')]")
public WebElement orderHeader;
public OrderDetailsPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
public boolean isOrderDetailsPageLoaded() {
    WaitUtils.VisibilityOfElement(driver, orderHeader);
    return orderHeader.isDisplayed();
}
}
