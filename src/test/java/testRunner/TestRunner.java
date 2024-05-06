package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/main/resources/features"},
        glue = {"stepDefinitions", "hooks", "screenshots", "locators"},
        tags = "@smoke",
        plugin = {"pretty", "json:target/cucumber.json", "html:target/site/cucumber-pretty", "junit:target/cucumber-results.xml", "html:target/cucumber.html", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        monochrome = true,
        publish = true
)

public class TestRunner {
}
