package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features= "src/test/resources/Feature/RegisterPage.feature",
		glue= {"StepDefinitions"},
		plugin= {"pretty", "html:target/cucumber-reports/cucumber.html","json:target/cucumber-reports/cucumber.json", "junit:target/cucumber-reports/cucumber.xml",
				 "junit:target/cucumber-reports/Cucumber.xml"},
		monochrome = true,
		dryRun = false,
	    tags = "@Smoke or @Regression" //run both having the smoke and regression tags

		)
public class RegisterRunner extends AbstractTestNGCucumberTests
{

}
