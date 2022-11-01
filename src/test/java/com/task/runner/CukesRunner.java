package com.task.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = "html:target/cucumber-report.html",
        glue = "com/task/step_definitions",
        features = "src/test/resources/features",
        dryRun = false,
        tags = "@webtableAppOrder"

)
public class CukesRunner {


}
