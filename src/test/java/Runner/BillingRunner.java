package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/Feature/BillingPage.feature",
    glue = {"StepDefinitions"},
    plugin = {
            "pretty",
            "html:target/cucumber-reports/billing-report.html",
            "json:target/cucumber-reports/billing-report.json",
            "junit:target/cucumber-reports/billing-report.xml",
            "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
    },
    monochrome = true,
    dryRun = false
)

public class BillingRunner extends AbstractTestNGCucumberTests 
{

}
