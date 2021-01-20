package finance.arvato.currencyconverter.apptests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"json:target/cucumber-reports/cucumber.json",
        "pretty", "html:target/cucumber-reports/cucumber-html-reports.html"},
        features = "./src/app-tests/java/finance/arvato/currencyconverter/apptests"
        )
public class AppTestsRunnerIT {
}
