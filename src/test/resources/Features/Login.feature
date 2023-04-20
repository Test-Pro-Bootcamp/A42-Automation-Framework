Feature: Login feature

  Scenario: Login Success
#    Given I open Login Page
    Given I enter email "demo@class.com"
    And I enter password "te$t$tudent"
    When I submit
    Then I am logged in