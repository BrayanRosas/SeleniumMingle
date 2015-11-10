@Login
Feature: Login

  @SmokeTest
  Scenario: User should be able to login using valid credentials
    Given I navigate to Login page
    When I sing in to page
    Then I should login to Mingle successfully