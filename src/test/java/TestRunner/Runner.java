package TestRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/Resources/Feature",
        glue = { "StepDef" },
        plugin = {"pretty", "html:target/cucumber-reports/cucumber-html-report.html","json:target/cucumber-reports/CucumberTestReport.json"},
        monochrome = true
)
public class Runner extends AbstractTestNGCucumberTests {
}
