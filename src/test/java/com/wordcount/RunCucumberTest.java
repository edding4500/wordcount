package com.wordcount;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
  features = "src/test/resources/com/wordcount/"
)
public class RunCucumberTest {
}