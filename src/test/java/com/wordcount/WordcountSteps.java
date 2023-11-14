package com.wordcount;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WordcountSteps {

  private WordCount wc;

  @Before
  public void before() {
    wc = null;
  }

  @After
  public void after() {
    wc = null;
  }

  @Given("I have a word count app")
  public void i_have_a_word_count_app() {
    wc = new WordCount();
    assert wc != null;
  }

  @When("I read in a file without duplicates")
  public void i_enter_a_text() {
    // Write code here that turns the phrase above into concrete actions
    wc.readFile("./src/test/java/com/wordcount/testUnique.txt");
  }

  @Then("I should see the word count of each word in the file")
  public void i_should_see_the_word_count_of_the_text() {
    // Write code here that turns the phrase above into concrete actions
    assert wc.getUniqueCount().size() == 4;
    assert wc.getUniqueCount().get("Mainz") == 1;
    assert wc.getUniqueCount().get("Hamburg") == 1;
    assert wc.getUniqueCount().get("Reutlingen") == 1;
    assert wc.getUniqueCount().get("Stuttgart") == 1;
  }
}
