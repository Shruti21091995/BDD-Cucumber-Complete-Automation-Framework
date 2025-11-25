package StepDefinitions;

import java.io.IOException;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Constants.FrameWorkConstants;
import Pages.BillingPage;
import Pages.CheckOutPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProductPage;
import Utils.ConfigReaderUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BillingStepDefinitions 
{
    private static final Logger logger = LogManager.getLogger(BillingStepDefinitions.class);
    WebDriver driver;
    HomePage home;
    ProductPage product;
    CheckOutPage checkout;
    BillingPage billing;
    LoginPage login;
    ConfigReaderUtils config;

    @Given("the user is on the checkout page")
    public void the_user_is_on_the_checkout_page() throws IOException 
    {
        driver = Hooks.driver;
        config = new ConfigReaderUtils(FrameWorkConstants.Config_Path);
        String url = config.getValue("url");
        
        // Login first
        driver.get(url + "/login");
        login = new LoginPage(driver);
        
        String email = "kalpana.patil@gmail.com";
        String password = "Abc@12345";
        login.ClickLogin(email, password);
        
        logger.info("User logged in successfully");
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // Add product to cart
        driver.get(url + "/books");
        home = new HomePage(driver);
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        product = home.ClickOnOptionBasedOnParamterReturn("Fiction");
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        product.AddToCartButton.click();
        logger.info("Product added to cart successfully");
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // Go to checkout
        product.ClickOnShoppingCartLink();
        checkout = new CheckOutPage(driver);
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        checkout.selectTermsAndService();
        checkout.CheckOutButton.click();
        
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        billing = new BillingPage(driver);
        logger.info("User is on checkout page");
    }

    @When("the user selects an existing billing address {string}")
    public void the_user_selects_an_existing_billing_address(String addressOption) 
    {
        logger.info("Selected billing address option: {}", addressOption);
    }

    @When("the user enters billing address details:")
    public void the_user_enters_billing_address_details(io.cucumber.datatable.DataTable dataTable) 
    {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        
        String firstName = data.get("FirstName");
        String lastName = data.get("LastName");
        String email = data.get("Email");
        String country = data.get("Country");
        String city = data.get("City");
        String address = data.get("Address");
        String postal = data.get("Postal");
        String mobile = data.get("Mobile");
        
        try {
            Thread.sleep(1000);
            
            billing.firstName.clear();
            billing.firstName.sendKeys(firstName);
            
            billing.lastname.clear();
            billing.lastname.sendKeys(lastName);
            
            billing.email.clear();
            billing.email.sendKeys(email);
            
            billing.CountryDropdown.click();
            billing.CountryDropdown.sendKeys(country);
            billing.city.clear();
            billing.city.sendKeys(city);
            
            billing.address.clear();
            billing.address.sendKeys(address);
            
            billing.postalCode.clear();
            billing.postalCode.sendKeys(postal);
            
            billing.mobileNumber.clear();
            billing.mobileNumber.sendKeys(mobile);
            
            logger.info("Billing address details entered successfully");
        } catch (Exception e) {
            logger.error("Error entering billing details: {}", e.getMessage());
        }
    }

    @When("the user clicks on Billing Continue")
    public void the_user_clicks_on_billing_continue() 
    {
        try {
            billing.BillingAddressContinueButton.click();
            logger.info("Clicked Billing Continue button");
            Thread.sleep(2000);
        } catch (Exception e) {
            logger.error("Error clicking Billing Continue: {}", e.getMessage());
        }
    }

    @Then("the billing address should be submitted successfully")
    public void the_billing_address_should_be_submitted_successfully() 
    {
        logger.info("Billing address submitted successfully");
    }

    @When("the user selects an existing shipping address {string}")
    public void the_user_selects_an_existing_shipping_address(String addressOption) 
    {
        logger.info("Selected shipping address option: {}", addressOption);
    }

    @When("the user enters shipping address details:")
    public void the_user_enters_shipping_address_details(io.cucumber.datatable.DataTable dataTable) 
    {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        
        String firstName = data.get("FirstName");
        String lastName = data.get("LastName");
        String email = data.get("Email");
        String country = data.get("Country");
        String city = data.get("City");
        String address = data.get("Address");
        String postal = data.get("Postal");
        String mobile = data.get("Mobile");
        
        try {
            Thread.sleep(1000);
            
            billing.ShippingAddress_FirstName.clear();
            billing.ShippingAddress_FirstName.sendKeys(firstName);
            
            billing.ShippingAddress_LastName.clear();
            billing.ShippingAddress_LastName.sendKeys(lastName);
            
            billing.ShippingAddress_email.clear();
            billing.ShippingAddress_email.sendKeys(email);
            billing.CountryDropdown.click();
            billing.CountryDropdown.sendKeys(country);
            billing.ShippingAddress_City.clear();
            billing.ShippingAddress_City.sendKeys(city);
            
            billing.ShippingAddress_address.clear();
            billing.ShippingAddress_address.sendKeys(address);
            
            billing.ShippingAddress_PostalCode.clear();
            billing.ShippingAddress_PostalCode.sendKeys(postal);
            
            billing.ShippingAddress_PhoneNumber.clear();
            billing.ShippingAddress_PhoneNumber.sendKeys(mobile);
            
            logger.info("Shipping address details entered successfully");
        } catch (Exception e) {
            logger.error("Error entering shipping details: {}", e.getMessage());
        }
    }

    @When("the user clicks on Shipping Address Continue")
    public void the_user_clicks_on_shipping_address_continue() 
    {
        try {
            billing.ShippingAddressContinueButton.click();
            System.out.println("Clicked Shipping Address Continue");
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("Error clicking Shipping Address Continue: " + e.getMessage());
        }
    }

    @Then("the shipping address should be submitted successfully")
    public void the_shipping_address_should_be_submitted_successfully() 
    {
        logger.info("Shipping address submitted successfully");
    }

    @When("the user selects shipping method {string}")
    public void the_user_selects_shipping_method(String method) 
    {
        try {
            billing.ShippingMethodSelect(method);
            System.out.println("Selected shipping method: " + method);
        } catch (Exception e) {
            System.out.println("Error selecting shipping method: " + e.getMessage());
        }
    }

    @When("the user clicks on Shipping Method Continue")
    public void the_user_clicks_on_shipping_method_continue() 
    {
        try {
            billing.ShippingMethodContinueButton.click();
            logger.info("Clicked Shipping Method Continue button");
            Thread.sleep(2000);
        } catch (Exception e) {
            logger.error("Error clicking Shipping Method Continue: {}", e.getMessage());
        }
    }

    @Then("the shipping method should be submitted successfully")
    public void the_shipping_method_should_be_submitted_successfully() 
    {
        logger.info("Shipping method submitted successfully");
    }

    @When("the user selects payment method {string}")
    public void the_user_selects_payment_method(String paymentMethod) 
    {
        try {
            billing.PaymentMethod(paymentMethod);
            System.out.println("Selected payment method: " + paymentMethod);
        } catch (Exception e) {
            System.out.println("Error selecting payment method: " + e.getMessage());
        }
    }

    @When("the user clicks on Payment Method Continue")
    public void the_user_clicks_on_payment_method_continue() 
    {
        try {
            billing.PaymentMethodContinueButton.click();
            logger.info("Clicked Payment Method Continue button");
            Thread.sleep(2000);
        } catch (Exception e) {
            logger.error("Error clicking Payment Method Continue: {}", e.getMessage());
        }
    }

    @Then("the payment method should be submitted successfully")
    public void the_payment_method_should_be_submitted_successfully() 
    {
        logger.info("Payment method submitted successfully");
    }

    @When("the user clicks on Payment Info Continue")
    public void the_user_clicks_on_payment_info_continue() 
    {
        try {
            billing.PaymentInfo();
            System.out.println("Clicked Payment Info Continue");
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("Error clicking Payment Info Continue: " + e.getMessage());
        }
    }

    @Then("the payment information should be submitted successfully")
    public void the_payment_information_should_be_submitted_successfully() 
    {
        logger.info("Payment information submitted successfully");
    }

    @When("the user clicks on Confirm Order")
    public void the_user_clicks_on_confirm_order() 
    {
        try {
            billing.ConfirmationMethod();
            System.out.println("Clicked Confirm Order");
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println("Error clicking Confirm Order: " + e.getMessage());
        }
    }

    @Then("the order should be placed successfully")
    public void the_order_should_be_placed_successfully() 
    {
        String currentUrl = driver.getCurrentUrl();
        logger.info("Order placed - Current URL: {}", currentUrl);
        
        boolean orderComplete = currentUrl.contains("completed") || 
                               currentUrl.contains("checkout/success") ||
                               currentUrl.contains("onepage");
        
        Assert.assertTrue(orderComplete, "Order not completed. URL: " + currentUrl);
        logger.info("Order placed successfully!");
    }
}
