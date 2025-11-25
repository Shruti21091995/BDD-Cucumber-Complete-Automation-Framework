package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		features ="src/test/resources/Feature/SearchProduct.feature",
		glue= {"StepDefinitions"},
		plugin= {"pretty","html:target/cucumber_reports/cucmber.htnml","json:target/cucumber_reports/cucumber.json",
				"junit:target/cucumber_reports/cucumber.xml","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
		tags="@Regression",
		monochrome=true,
		dryRun=false
)

public class SearchPageRunner extends AbstractTestNGCucumberTests
{

}
