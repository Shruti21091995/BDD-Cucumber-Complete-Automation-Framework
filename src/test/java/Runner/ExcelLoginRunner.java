package Runner;

import Utils.ExcelReaderUtils;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/Feature/LoginUsingExcel.feature",
        glue = {"StepDefinitions"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports/excel-login-report.html",
                "json:target/cucumber-reports/excel-login-report.json",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "junit:target/cucumber-reports/Cucumber.xml"
        },
        monochrome = true,
        dryRun = false
)
public class ExcelLoginRunner extends AbstractTestNGCucumberTests
{
	public static Object[][] excelData;

	static {
		try {
			ExcelReaderUtils excel = new ExcelReaderUtils();
			excel.SetExcelFilePath("./src/test/resources/DataFiles/LoginData.xlsx", "Sheet1");

			int rows = excel.GetNoOfRows();
			int cols = excel.GetNoOfColumns();

			excelData = new Object[rows - 1][cols];

			for (int i = 1; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					excelData[i - 1][j] = excel.GetData(i, j);
				}
			}

			excel.close();
			org.apache.logging.log4j.LogManager.getLogger(ExcelLoginRunner.class).info("Excel data loaded successfully. Rows: {}", excelData.length);
		} catch (Exception e) {
			org.apache.logging.log4j.LogManager.getLogger(ExcelLoginRunner.class).error("Error loading Excel data: {}", e.getMessage());
			e.printStackTrace();
			excelData = new Object[0][0]; // Initialize empty array to avoid null
		}
	}
}

