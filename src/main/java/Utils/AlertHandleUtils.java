package Utils;
import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertHandleUtils 
{
	private static final int DEFAULT_WAIT_TIME = 10; // seconds

	    /**
	     * Wait until alert is present and switch to it
	     */
	    public static Alert waitForAlert(WebDriver driver) {
	        try {
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_WAIT_TIME));
	            wait.until(ExpectedConditions.alertIsPresent());
	            Alert alert = driver.switchTo().alert();
	            System.out.println("✅ Alert is present.");
	            return alert;
	        } catch (TimeoutException e) {
	            System.err.println("❌ No alert appeared within " + DEFAULT_WAIT_TIME + " seconds.");
	            return null;
	        }
	    }

	    /**
	     * Accept (Click OK) on the alert
	     */
	    public static void acceptAlert(WebDriver driver) {
	        try {
	            Alert alert = waitForAlert(driver);
	            if (alert != null) {
	                alert.accept();
	                System.out.println("✅ Alert accepted.");
	            }
	        } catch (NoAlertPresentException e) {
	            System.err.println("❌ No alert to accept: " + e.getMessage());
	        }
	    }

	    /**
	     * Dismiss (Click Cancel) on the alert
	     */
	    public static void dismissAlert(WebDriver driver) {
	        try {
	            Alert alert = waitForAlert(driver);
	            if (alert != null) {
	                alert.dismiss();
	                System.out.println("✅ Alert dismissed.");
	            }
	        } catch (NoAlertPresentException e) {
	            System.err.println("❌ No alert to dismiss: " + e.getMessage());
	        }
	    }

	    /**
	     * Get text displayed on alert
	     */
	    public static String getAlertText(WebDriver driver) {
	        try {
	            Alert alert = waitForAlert(driver);
	            if (alert != null) {
	                String alertText = alert.getText();
	                System.out.println("✅ Alert text: " + alertText);
	                return alertText;
	            }
	        } catch (NoAlertPresentException e) {
	            System.err.println("❌ No alert to get text from: " + e.getMessage());
	        }
	        return null;
	    }

	    /**
	     * Send keys (input) to prompt alert
	     */
	    public static void sendKeysToAlert(WebDriver driver, String inputText) {
	        try {
	            Alert alert = waitForAlert(driver);
	            if (alert != null) {
	                alert.sendKeys(inputText);
	                System.out.println("✅ Sent input to alert: " + inputText);
	            }
	        } catch (NoAlertPresentException e) {
	            System.err.println("❌ No alert to send keys: " + e.getMessage());
	        }
	    }

	    /**
	     * Verify if alert is present
	     */
	    public static boolean isAlertPresent(WebDriver driver) {
	        try {
	            driver.switchTo().alert();
	            System.out.println("✅ Alert is present.");
	            return true;
	        } catch (NoAlertPresentException e) {
	            System.out.println("ℹ️ No alert present.");
	            return false;
	        }
	    }

	    /**
	     * Handle alert based on expected message
	     */
	    public static void handleAlertIfTextContains(WebDriver driver, String expectedText, boolean accept) {
	        try {
	            Alert alert = waitForAlert(driver);
	            if (alert != null) {
	                String text = alert.getText();
	                if (text.contains(expectedText)) {
	                    if (accept) {
	                        alert.accept();
	                        System.out.println("✅ Accepted alert with text: " + text);
	                    } else {
	                        alert.dismiss();
	                        System.out.println("✅ Dismissed alert with text: " + text);
	                    }
	                } else {
	                    System.out.println("ℹ️ Alert text did not match expected: " + text);
	                }
	            }
	        } catch (Exception e) {
	            System.err.println("❌ Error handling alert: " + e.getMessage());
	        }
	    }

	    /**
	     * Wait and accept alert silently (used in teardown or cleanup)
	     */
	    public static void acceptAlertIfPresent(WebDriver driver) {
	        if (isAlertPresent(driver)) {
	            driver.switchTo().alert().accept();
	            System.out.println("✅ Accepted alert automatically (if present).");
	        }
	    }
	}


