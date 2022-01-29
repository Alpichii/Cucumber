@HeroApp
Feature: Validate Hero App Pages

  Background:
    Given user is on "http://the-internet.herokuapp.com/"

  Scenario: Validate add/remove element page
    When user clicks on "Add/Remove Elements" link
    Then user should see "Add/Remove Elements" heading
    And user should see "Add Element" button
    When user clicks on "Add Element" button
    Then user should see "Delete" button
    When user clicks on "Delete" button
    Then user should not see "Delete" button


  Scenario: Validate context menu page
    When user clicks on "Context Menu" link
    Then user should see "Context Menu" heading
    And user should see "Context menu items are custom additions that appear in the right-click menu." text
    And user should see "Right-click in the box below to see one called 'the-internet'. When you click it, it will trigger a JavaScript alert." text
    And user should see a rectangle box to right click