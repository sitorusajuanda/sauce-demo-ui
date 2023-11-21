package StepDef;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


    @RunWith(Cucumber.class)
    @CucumberOptions(
            tags = {"@Login"},
            glue = {"classpath:stepDef"},
            features = {"classpath:Features/"},
            plugin = {"pretty","html:target/site/cucumber-pretty","json:target/cucumber/cucumber.json"}

    )
    public class RunCukesTest {

    }





