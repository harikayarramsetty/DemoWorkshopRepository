package com.cts.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@CucumberOptions(features= {"src/main/resources/feature/demo.feature"},tags = {"@valid"},
     glue = {"com/cts/stepdefinitions"}
    // monochrome = true, plugin = {"html.repots/","pretty"}
     )

@RunWith(Cucumber.class)
public class RunnerTest {

}
