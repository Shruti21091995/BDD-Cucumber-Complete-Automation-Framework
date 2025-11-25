package Runner;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/Feature/BillingPage.feature",
    glue = {"StepDefinitions"},
    plugin = {
            "pretty",
            "html:target/cucumber-reports/cucumber.html",
            "json:target/cucumber-reports/cucumber.json",
            "junit:target/cucumber-reports/cucumber.xml",
            "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
    },
    monochrome = true,
    dryRun = false
)

public class TestRunner extends AbstractTestNGCucumberTests 
{
@BeforeClass
@Parameters("browser")
 public void SetUpBrowser(@Optional("") String browser)
 {
	 if(browser!=null && !browser.isBlank())
	 {
		 System.setProperty("BrowserName", browser);
	 }
 }
}
/*

////////////master runner////////////////
package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/Features",
    glue = {"StepDefinitions"},
    plugin = {
            "pretty",
            "html:target/cucumber-reports/master-report.html",
            "json:target/cucumber-reports/master-report.json",
            "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
    },
    monochrome = true,
    dryRun = false
)
public class MasterRunner extends AbstractTestNGCucumberTests {

}
///////////////smoke runner////////////////
package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/Features",
    glue = {"StepDefinitions"},
    tags = "@Smoke",
    plugin = {
            "pretty",
            "html:target/cucumber-reports/smoke-report.html",
            "json:target/cucumber-reports/smoke-report.json",
            "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
    },
    monochrome = true
)
public class SmokeRunner extends AbstractTestNGCucumberTests {

}
/////////regression runner////////////////
package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/Features",
    glue = {"StepDefinitions"},
    tags = "@Regression",
    plugin = {
            "pretty",
            "html:target/cucumber-reports/regression-report.html",
            "json:target/cucumber-reports/regression-report.json",
            "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
    },
    monochrome = true
)
public class RegressionRunner extends AbstractTestNGCucumberTests {

}
//////////cross browser + parallel Runner
package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
    features = "src/test/resources/Features",
    glue = {"StepDefinitions"},
    plugin = {
            "pretty",
            "html:target/cucumber-reports/parallel-report.html",
            "json:target/cucumber-reports/parallel-report.json",
            "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
    },
    monochrome = true
)
public class ParallelRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)  // enables parallel mode
    public Object[][] scenarios() {
        return super.scenarios();
    }
}

 */

