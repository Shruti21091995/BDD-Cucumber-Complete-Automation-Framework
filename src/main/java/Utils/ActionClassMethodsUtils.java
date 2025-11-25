package Utils;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput.ScrollOrigin;

public class ActionClassMethodsUtils
{
	    /**
	     * Hover over an element.
	     */
	    public static void hoverOnElement(WebDriver driver, WebElement element) 
	    {
	       
	            Actions actions = new Actions(driver);
	            actions.moveToElement(element).perform();
	            System.out.println("✅ Hovered on element: " + element);
	       
	    }

	    /**
	     * Right click (context click) on an element.
	     */
	    public static void rightClick(WebDriver driver, WebElement element) 
	    {
	           Actions actions = new Actions(driver);
	            actions.contextClick(element).perform();
	            System.out.println("✅ Right clicked on element: " + element);
	      
	    }

	    /**
	     * Double click on an element.
	     */
	    public static void doubleClick(WebDriver driver, WebElement element) 
	    {
	       
	            Actions actions = new Actions(driver);
	            actions.doubleClick(element).perform();
	            System.out.println("✅ Double clicked on element: " + element);
	       
	    }

	    /**
	     * Click and hold on an element.
	     */
	    public static void clickAndHold(WebDriver driver, WebElement element) 
	    {
	      
	            Actions actions = new Actions(driver);
	            actions.clickAndHold(element).perform();
	            System.out.println("✅ Clicked and held on element: " + element);
	       
	    }

	    /**
	     * Release mouse after click and hold.
	     */
	    public static void release(WebDriver driver, WebElement element) 
	    {
	       
	            Actions actions = new Actions(driver);
	            actions.release(element).perform();
	            System.out.println("✅ Released mouse on element: " + element);
	       
	    }

	    /**
	     * Drag and drop one element to another.
	     */
	    public static void dragAndDrop(WebDriver driver, WebElement source, WebElement target)
	    {
	       
	            Actions actions = new Actions(driver);
	            actions.dragAndDrop(source, target).perform();
	            System.out.println("✅ Dragged and dropped element successfully");
	      
	    }

	    /**
	     * Drag and drop by offset.
	     */
	    public static void dragAndDropByOffset(WebDriver driver, WebElement source, int xOffset, int yOffset) 
	    {
	       
	            Actions actions = new Actions(driver);
	            actions.dragAndDropBy(source, xOffset, yOffset).perform();
	            System.out.println("✅ Dragged element by offset (" + xOffset + ", " + yOffset + ")");
	     
	    }

	    /**
	     * Scroll to element (Selenium 4+).
	     */
	    public static void scrollToElement(WebDriver driver, WebElement element)
	    {
	            Actions actions = new Actions(driver);
	            actions.scrollToElement(element).perform();
	            System.out.println("✅ Scrolled to element: " + element);
	        
	    }

	    /**
	     * Scroll by amount (Selenium 4+).
	     */
	    public static void scrollByAmount(WebDriver driver, int xOffset, int yOffset) 
	    {
	       
	            Actions actions = new Actions(driver);
	            actions.scrollByAmount(xOffset, yOffset).perform();
	            System.out.println("✅ Scrolled by (" + xOffset + ", " + yOffset + ")");
	       
	    }

	    /**
	     * Send keys to an element.
	     */
	    public static void sendKeys(WebDriver driver, WebElement element, CharSequence keys) 
	    {
	       
	            Actions actions = new Actions(driver);
	            actions.sendKeys(element, keys).perform();
	            System.out.println("✅ Sent keys '" + keys + "' to element");
	       
	    }

	    /**
	     * Press a key down (modifier like SHIFT, CTRL, ALT).
	     */
	    public static void keyDown(WebDriver driver, Keys key) 
	    {
	            Actions actions = new Actions(driver);
	            actions.keyDown(key).perform();
	            System.out.println("✅ Key down: " + key.name());
	       
	    }

	    /**
	     * Release a key.
	     */
	    public static void keyUp(WebDriver driver, Keys key) 
	    {
	            Actions actions = new Actions(driver);
	            actions.keyUp(key).perform();
	            System.out.println("✅ Key up: " + key.name());
	      
	    }

	    /**
	     * Scroll from specific origin (advanced Selenium 4 feature).
	     */
	    public static void scrollFromOrigin(WebDriver driver, WebElement element, int x, int y) 
	    {
	            Actions actions = new Actions(driver);
	            actions.scrollFromOrigin(ScrollOrigin.fromElement(element), x, y).perform();
	            System.out.println("✅ Scrolled from origin of element by (" + x + ", " + y + ")");
	        
	    }
	}


