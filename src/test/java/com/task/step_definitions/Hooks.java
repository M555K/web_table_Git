package com.task.step_definitions;

import com.task.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
  //  @Before
    public void setupScenario(){
        System.out.println("Setting up browser using cucumber @Before each scenario");
    }

  ///  @Before (value = "@login", order=2)
    public void setupForLogin(){
        // if you want any code to run before any specific feature or scenario you can use value = "@tagname" to determine this
        System.out.println("Setting up browser using cucumber @Before @login scenario");
        Driver.getDriver().get("URL of your app");

    }
  //  @Before(value = "@db", order = 3)
    public void setupDatabaseScenario(){

    }
    @After
    public void teardownScenario(Scenario scenario){
        if(scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
       Driver.closeDriver();
    }

    //@BeforeStep
    public void setupScenarioStep(){
        System.out.println("Setting up browser using cucumber @Before each scenario step");
    }

    // @BeforeStep
    public void setupScenarioStepForLogin(){
        System.out.println("Setting up browser using cucumber @Before each scenario step for login");
    }

}
