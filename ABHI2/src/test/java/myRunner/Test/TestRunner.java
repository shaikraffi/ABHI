package myRunner.Test;

import org.junit.runner.RunWith;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@Test
@RunWith(Cucumber.class)

@CucumberOptions(
        features = "src/main/java/features/TPD.feature",
        glue = {"stepDefinations"},
        		dryRun = true,
        format ={"pretty",
            "html:target/cucumber-reports/cucumber-pretty"})
	public class TestRunner {


}
