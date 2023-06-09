package Runners;

import com.aventstack.extentreports.service.ExtentService;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;

@CucumberOptions(
        tags = "@Regression or @SmokeTest",
        features = {"src/test/java/FeatureFiles"},
        glue = {"StepDefinitions"},
        plugin = {"pretty", "html:target/site/cucumber-pretty.html", "json:target/cucumber/cucumber.json"}
)

public class _08_TestRunnerMasterReport extends AbstractTestNGCucumberTests {

}
