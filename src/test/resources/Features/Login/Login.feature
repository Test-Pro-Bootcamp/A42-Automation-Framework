Feature: Login feature

  Scenario: Login Success
    Given I open browser
    And I open Login Page
    When I enter email"lidiia@northins.com"
    And I enter password"Lidiia1807@"
    And I submit
    Then I am logged in