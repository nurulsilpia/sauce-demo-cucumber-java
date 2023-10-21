package TestRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features",
        glue = {"StepDefinitions", "appHooks"},
        //tags = "@Transaction",
        plugin = {"pretty", "html:target/HtmlReports.html",
                "json:target/cucumber.json"},
        publish = true,
        monochrome = true
)

public class TestRunner {
}
