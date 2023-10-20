@activity2
Feature: Login Test

Scenario: Login Test
  Given User is on Login page
  When User enters username and password
  Then Read the page title and confirmation message
  And Close the Browser Page