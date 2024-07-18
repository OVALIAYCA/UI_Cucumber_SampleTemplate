@Smoke
Feature:  As a user I should be able to access the home page
  Background:
    Given Open browser and Go to "url"
  Scenario: Login as admin
    When Click on the login button
    And Enter the valid "UserName" and valid "Password"
    Then Go to Employee List page
    And Click on the Create New button for the new employee
    Then Enter the valid "name", "salary", "durationWorked", "email" information for create a new employee
    And Verify the new employee "name" info in Employee List page
    And Delete the new employee
    And Verify the new employee "name" deleted in Employee List page
    Then Close the page