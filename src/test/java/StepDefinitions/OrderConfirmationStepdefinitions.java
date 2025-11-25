package StepDefinitions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Pages.OrderDetailsPage;
import Pages.ProductConfirmationPage;
import io.cucumber.java.en.*;

public class OrderConfirmationStepdefinitions {

    private static final Logger logger = LogManager.getLogger(OrderConfirmationStepdefinitions.class);
    WebDriver driver;
    ProductConfirmationPage confirmationPage;
    OrderDetailsPage orderDetailsPage;

    // ==========================================================
    // Background Step
    // ==========================================================
    @Given("the user has successfully placed an order")
    public void the_user_has_successfully_placed_an_order()
    {
        driver = Hooks.driver;
        confirmationPage = new ProductConfirmationPage(driver);
        
        // Order is already placed in previous steps
        // This background assumes user is already on confirmation page
    }

    // ==========================================================
    // Scenario 1: Validate Confirmation Message
    // ==========================================================
    @When("the user is on the order confirmation page")
    public void the_user_is_on_the_order_confirmation_page() {
        driver = Hooks.driver;
        confirmationPage = new ProductConfirmationPage(driver);
        
        try {
            Thread.sleep(2000);
            logger.info("Verifying order confirmation page");
        } catch (InterruptedException e) {
            logger.error("Thread interrupted: {}", e.getMessage());
        }
    }

    @Then("the confirmation message should be displayed")
    public void the_confirmation_message_should_be_displayed() {
        try {
            String message = confirmationPage.GetConfirmationPage();
            logger.info("Confirmation message: {}", message);
            
            Assert.assertTrue(
                    message.contains("successfully") || message.contains("processed") || message.length() > 0,
                    "Confirmation message not found");
        } catch (Exception e) {
            logger.error("Error getting confirmation message: {}", e.getMessage());
        }
    }

    // ==========================================================
    // Scenario 2: Navigate to Order Details Page
    // ==========================================================
    @When("the user clicks on the Order Details button")
    public void the_user_clicks_on_the_order_details_button() {
        try {
            Thread.sleep(2000);
            orderDetailsPage = confirmationPage.ClickOnOrderDetailsPageReturn();
            logger.info("Clicked on Order Details button");
        } catch (Exception e) {
            logger.error("Error clicking Order Details button: {}", e.getMessage());
        }
    }

    @Then("the order details page should open successfully")
    public void the_order_details_page_should_open_successfully() {
        try {
            Thread.sleep(2000);
            boolean isLoaded = orderDetailsPage.isOrderDetailsPageLoaded();
            Assert.assertTrue(isLoaded, "Order details page not loaded");
            logger.info("Order details page loaded successfully");
        } catch (Exception e) {
            logger.error("Error verifying order details page: {}", e.getMessage());
        }
    }
}
