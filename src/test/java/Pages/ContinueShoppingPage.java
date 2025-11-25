package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ContinueShoppingPage 
{
WebDriver driver;
public ContinueShoppingPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

}
