@url
Feature:  As a user I should be able to access the home page
  Background:
    * Open browser and Go to "url"
  Scenario: The user must be able to access the home page
    * Verify that title is "IT Bootcamp Courses, Online Classes - Wise Quarter Course"
    * Close the page