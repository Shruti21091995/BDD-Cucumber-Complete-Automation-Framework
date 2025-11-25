package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

@CucumberOptions(
    features = "src/test/resources/Feature",
    glue = {"StepDefinitions"},
    plugin = {
            "pretty",
            "html:target/cucumber-reports/master-report.html",
            "json:target/cucumber-reports/master-report.json",
            "junit:target/cucumber-reports/master-report.xml",
            "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
    },
    monochrome = true,
    dryRun = false
)
public class MasterRunner extends AbstractTestNGCucumberTests {

    @BeforeClass
    @Parameters({"browser"})
    public void setBrowser(String browser) {
        System.setProperty("BrowserName", browser);
        org.apache.logging.log4j.LogManager.getLogger(MasterRunner.class).info("Running tests on browser: {}", browser);
    }
}
