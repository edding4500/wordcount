Feature: Have a word count app
      As a user
      I want to have a word count app
      So that I can see the word count of a text

  Scenario: User can see the word count of a text
    Given I have a word count app
    When I read in a file
    Then I should see the word count of each word in the file