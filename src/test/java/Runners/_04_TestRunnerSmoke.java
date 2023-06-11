package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        tags = "@SmokeTest", // hangi senaryolarda bu etiket varsa onlar çalıştırılacak
        features = {"src/test/java/FeatureFiles"},
        glue = {"StepDefinitions"},
        plugin= {"pretty","html:target/site/cucumber-pretty","json:target/cucumber/cucumber.json"}
        //plugin={"html:target/cucumber-html-report", "json:target/cucumber.json",
        //        "pretty:target/cucumber-pretty.txt","usage:target/cucumber-usage.json",
        //        "junit:target/cucumber-results.xml"}
)
public class _04_TestRunnerSmoke extends AbstractTestNGCucumberTests {
}
