package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = {
        "src/test/resources/Feature/BillingPage.feature",
        "src/test/resources/Feature/orderconfirmation.feature"
    },
    glue = {"StepDefinitions"},
    plugin = {
            "pretty",
            "html:target/cucumber-reports/order-confirmation-report.html",
            "json:target/cucumber-reports/order-confirmation-report.json",
            "junit:target/cucumber-reports/order-confirmation-report.xml",
            "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
    },
    monochrome = true,
    dryRun = false
)

public class OrderConfirmationRunner extends AbstractTestNGCucumberTests 
{

}
