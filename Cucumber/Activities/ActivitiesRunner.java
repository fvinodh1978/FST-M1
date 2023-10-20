package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Features",
        glue = {"stepDefinitions"},
        tags = "@activity6",
        plugin = {
                "html:src/reports/HTML_report"
        },
        monochrome=true
)

public class ActivitiesRunner {
}
