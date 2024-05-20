package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

        @CucumberOptions(
                features = "src/test/resources/features",
                glue = "stepdefinitions",
                plugin = {"pretty", "html:target/cucumber-reports/ParallelRunner.html"}
        )

public class ParallelRunner extends AbstractTestNGCucumberTests {
        @Override
        @DataProvider(parallel = true)
        public Object[][] scenarios() {
            return super.scenarios();
        }

}
