#Every feature file must start with the definition of the feature
@GoogleTest
Feature: Google Search Functionality

  @Test1
  Scenario: Validate Google search
    Given user is on "https://www.google.com/"
    When user searches for "Tesla"
    Then user should see "Tesla" in the url
    And user should see "Tesla" in the title


  @Test2
  Scenario: Validate Google search results
    Given user is on "https://www.google.com/"
    When user searches for "Test Automation"
    Then user should see results are more than 0